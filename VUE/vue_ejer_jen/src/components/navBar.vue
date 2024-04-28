<template>
  <v-container>
    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
    
      <v-img alt="Vuetify Logo" class="shrink mr-2" contain
        src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png" transition="scale-transition" width="40" />


      <v-toolbar-title v-text="title"></v-toolbar-title>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app>

      <v-list v-for=" (item, key) in items" :key="key" @click="drawer = !drawer">
        <v-list-item :to="{ name: item.name }">
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title >{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-container>
</template>
  
<script>

export default {
  name: 'nav_bar',

  data: () => ({
    drawer: false,
    title: 'JENAPP',
    items: [
      { title: 'Home', icon: 'mdi-home', name: 'home' },
      { title: 'Ejercicio 1', icon: 'mdi-music-box-multiple', name: 'uno' },
      { title: 'Ejercicio 2', icon: 'mdi-api', name: 'dos' },
    ],
  }),
};
</script>
<style>
.v-list-item-content {
  background-color: #ffffff !important;
  /*  Color de fondo para los elementos */
  cursor: pointer;
  /* Indicar que los elementos son clicables */
}

.v-list-item:hover {
  background-color: #e0e0e0 !important;
  /* Cambiar el color de fondo al pasar el cursor */
}
</style>