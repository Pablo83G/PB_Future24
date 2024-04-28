import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    artists: ['Robe'],
    albums: ['Se nos lleva el aire'],
  },
  mutations: {
    addArtistMutation(state,artist) {
      state.artists.push(artist);
    },
    editArtistMutation(state, {oldArtist, newArtist}) {
      const index = state.artists.findIndex((existingArtist) => existingArtist === oldArtist)
      if(index >-1){
        // state.artists[index] = newArtist;
        Vue.set(state.artists, index, newArtist) //Vue.set metodo propio de vue que sirve actualizar y notificar del cambio para que se actualice
      }
    },
    deleteArtistMutation(state, artist) {
      const index = state.artists.findIndex((existingArtist) => existingArtist === artist)
      state.artists.splice(index,1);
    },
    /******************************************************************************************** */
    addAlbumMutation(state,album) {
      state.albums.push(album);
    },
    editAlbumMutation(state, {oldAlbum, newAlbum}) {
      const index = state.albums.findIndex((existingAlbum) => existingAlbum === oldAlbum)
      if(index >-1){
        // state.artists[index] = newArtist;
        Vue.set(state.albums, index, newAlbum) //Vue.set metodo propio de vue que sirve actualizar y notificar del cambio para que se actualice
      }
    },
    deleteAlbumMutation(state, album) {
      const index = state.albums.findIndex((existingAlbum) => existingAlbum === album)
      state.albums.splice(index,1);
    }
  },
  actions: {
    addArtistAction({commit}, artist){
      commit('addArtistMutation',artist)
    },
    editArtistAction({commit},{oldArtist, newArtist}){
      commit('editArtistMutation',{oldArtist, newArtist})
    },
    deleteArtistAction({commit}, artist){
      commit('deleteArtistMutation',artist)
    },
    /********************************************************************************************************* */
    addAlbumAction({commit}, album){
      commit('addAlbumMutation',album)
    },
    editAlbumAction({commit},{oldAlbum, newAlbum}){
      commit('editAlbumMutation',{oldAlbum, newAlbum})
    },
    deleteAlbumAction({commit}, album){
      commit('deleteAlbumMutation',album)
    },
  },

  getters: {
    getAllArtist:(state)=>state.artists,
    getAllAlbums:(state)=>state.albums,
  },
  modules: {
  }
})

//  mutations: {
//     /**
//      * Generic mutation for adding, editing, or deleting items.
//      * @param {String} stateProperty - Name of the state property (e.g. 'artists', 'albums')
//      * @param {Object} payload - Data for the operation (e.g. { item: 'New Item' } for add, { oldName: 'Old Name', newName: 'New Name' } for edit)
//      * @param {String} mutationType - Type of operation (e.g. 'ADD', 'EDIT', 'DELETE')
//      */
//     crudMutation(state, { stateProperty, payload, mutationType }) {
//       const items = state[stateProperty];
//       const index = mutationType === 'EDIT' ? items.findIndex(item => item === payload.oldName) : -1;

//       switch (mutationType) {
//         case 'ADD':
//           items.push(payload[stateProperty]); // Use stateProperty as key for dynamic data
//           break;
//         case 'EDIT':
//           if (index > -1) {
//             Vue.set(items, index, payload.newName);
//           }
//           break;
//         case 'DELETE':
//           if (index > -1) {
//             items.splice(index, 1);
//           }
//           break;
//       }
//     },
//   },
//   actions: {
//     /**
//      * Generic action for adding, editing, or deleting items.
//      * @param {String} stateProperty - Name of the state property (e.g. 'artists', 'albums')
//      * @param {Object} payload - Data for the operation (e.g. { item: 'New Item' } for add, { oldName: 'Old Name', newName: 'New Name' } for edit)
//      * @param {String} mutationType - Type of operation (e.g. 'ADD', 'EDIT', 'DELETE')
//      */
//     crudAction({ commit }, { stateProperty, payload, mutationType }) {
//       commit('crudMutation', { stateProperty, payload, mutationType });
//     },
//   },
//   getters: {
//     getAllArtists: (state) => state.artists,
//     getAllAlbums: (state) => state.albums,
//   },
//   modules: {},

