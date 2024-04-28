<template>
    <v-container>
        <h1>Ejercicio 2</h1>
        <v-row justify="center">
            <v-col v-for="(character, key) in apiData" :key="key" cols="12" sm="6" md="4" lg="3">
                <card :id="character.id"
                 :name="character.name" 
                 :status="character.status" 
                 :species="character.species"
                 :gender="character.gender"
                 :image="character.image"
                 />
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios';
import card from '../components/Card.vue'
const URL = 'https://rickandmortyapi.com/api/character'

export default {
    
    name: 'dos',

    components: {
        card
    },
    //define la variable que va a contener los datos recibidos de la API y su estado inicial
    data:()=>({
        apiData:null
    }),
    //Realiza la petición a la API cuando el componente está montado
    mounted(){
       this.fetchData();
    },
    methods:{
        //Realiza la petición a la API con la librería AXIOS
        async fetchData(){
            try{
                const response = await axios.get(URL);
                this.apiData= response.data.results;//Vuelca la respuesta de la API con nuestra variable
            }catch(err){
                console.error('Error petición', err)
            }
        }
    }
}
</script>
