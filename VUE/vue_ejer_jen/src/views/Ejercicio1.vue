<template>
    <v-container>
        <h1>Ejercicio 1</h1>
        <Artists></Artists>
        <Albums></Albums>
    </v-container>
    

</template>
  
<script>

import Artists from '@/components/Artists.vue';
import Albums from '@/components/Albums.vue'

export default {
    name: 'uno',

    components: {
        Artists, Albums
    },
}
</script>
  