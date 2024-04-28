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

import card from '../components/Card.vue'


export default {
    
    name: 'dos',

    components: {
        card
    },
    mounted(){
        this.$store.dispatch('fetchApiData');
    },
    computed: {
    apiData() {
      return this.$store.getters['getApiData'];
    },
  },
}
</script>
