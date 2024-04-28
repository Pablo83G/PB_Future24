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
    addMutation(state, {type, newData}){
      const items =state[type];// Se recupera el array del objeto 'state' utilizando la propiedad 'type' proporcionada.Esto permite manejar diferentes tipos de datos
      items.push(newData);
    },
    editMutation(state, {type,oldData, newData}) {
        const items =state[type];
        const index = items.findIndex((existingData) => existingData === oldData)
        if (index > -1) {
          Vue.set(items, index, newData) //Vue.set metodo propio de vue que sirve actualizar y notificar del cambio para que se actualice
        }
      },
    deleteMutation(state, {type,oldData}) {
        const items =state[type];
        const index = items.findIndex((existingData) => existingData === oldData)
        items.splice(index, 1);
    },
    
    setApiData(state, data) {
      state.apiData = data;
    },
  },
  actions: {
    addAction({ commit }, {type, newData}){
      commit('addMutation', { type, newData })
    },
    editAction({ commit }, { type, oldData, newData }) {
      commit('editMutation', { type, oldData, newData })
    },
    deleteAction({ commit }, { type, oldData }) {
      commit('deleteMutation',{ type, oldData })
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



