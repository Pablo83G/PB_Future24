<template>
  <v-app><!--Elemento raiz de Vuetify que contiene toda la app-->
  <nav_bar></nav_bar>
 
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import nav_bar from './components/navBar.vue'


export default {
  
  name: 'App',

  data: () => ({
    
  }),
  components: {
     nav_bar 
    },
};
</script>
