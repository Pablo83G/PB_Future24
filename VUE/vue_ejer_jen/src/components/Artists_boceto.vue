<template>
    <v-container>
        <h2>Listado de Artistas</h2>
        <ul>
            <li v-for=" (artist, key) in $store.state.artists" :key="key">
                {{ artist }}
                <input type="text" v-model="editArtistName" >
                <v-btn @click="editArtist(artist)">Editar</v-btn>
                <v-btn @click="deleteArtist(artist)">Eliminar</v-btn>
            </li>
        </ul>
        <input type="text" v-model="newArtistName">
        <v-btn @click="addArtist">Añadir artista</v-btn>
    </v-container>
</template>
<script>
export default {

    name: 'Artists',
    
    methods: {
      addArtist(){
        this.$store.dispatch('addArtist',this.newArtistName);
        this.newArtistName=''
      },
      editArtist(artist){
        this.$store.dispatch('editArtist',{oldArtist: artist, newArtist: this.editArtistName});
        console.log(artist, this.editArtistName)
        this.editArtistName=''
      }
      ,
      deleteArtist(artist){
        this.$store.dispatch('deleteArtist',artist);
      }
    },
    

    data:()=>({
       newArtistName:'',
       editArtistName:'',

       
    }),
    
 

}

</script>