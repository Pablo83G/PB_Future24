<template>
  <v-container>
      <hello-world />
  </v-container>

 
</template>

<script>
  import HelloWorld from '../components/HelloWorld'

  export default {
    name: 'Home',

    components: {
      HelloWorld,
    },
  }
</script>
<style>
main{
  background-color: #E3F2FD;
}
</style>