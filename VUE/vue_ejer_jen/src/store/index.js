import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    artists: [],
    albums: [],
    apiData: null,
  },
  mutations: {
    addMutation(state, {type, newObject}){
      const items =state[type];// Se recupera el array del objeto 'state' utilizando la propiedad 'type' proporcionada.Esto permite manejar diferentes tipos de datos
      items.push(newObject);
    },
    editMutation(state, {type,oldObject, newName,newArtist}) {
        const items =state[type];
        const index = items.findIndex((existingObject) => existingObject.id == oldObject.id)
        if (index > -1) {
          const updatedObject={...oldObject};
          if(newName!== ''){//comprueba que el nuevo nombre tenga valor para cambiarlo
            updatedObject.name=newName;
          }
          if(newArtist!== undefined){
            updatedObject.artist= newArtist;
          }
          Vue.set(items, index, updatedObject) //Vue.set metodo propio de vue que sirve actualizar y notificar del cambio para que se actualice
        }
      },
    deleteMutation(state, {type,oldObject}) {
        const items =state[type];
        const index = items.findIndex((existingObject) => existingObject.id === oldObject.id)
        items.splice(index, 1);
    },
    
    setApiData(state, data) {
      state.apiData = data;
    },
  },
  actions: {
    addAction({ commit }, {type, newObject}){
      commit('addMutation', { type, newObject })
    },
    editAction({ commit }, { type, oldObject, newName ,newArtist}) {
      commit('editMutation', { type, oldObject, newName,newArtist })
    },
    deleteAction({ commit }, { type, oldObject }) {
      commit('deleteMutation',{ type, oldObject })
    },
    async fetchApiData({ commit }) {
      try {
        const response = await axios.get('https://rickandmortyapi.com/api/character');
        commit('setApiData', response.data.results);
      } catch (err) {
        console.error('Error petición', err);
      }
    },
  },

  getters: {
    getAllArtist(state) { return state.artists },
    getAllAlbums(state) { return state.albums },
    getApiData(state) { return state.apiData },
  },

})



