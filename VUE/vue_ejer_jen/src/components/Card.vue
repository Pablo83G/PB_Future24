<template>
    <v-card :id="id" class="mx-auto my-12" max-width="374">
        <v-img height="auto" :src="image"></v-img>
        <v-card-title>{{name}}</v-card-title>
        <v-divider class="mx-4"></v-divider>
        <v-card-text>
            <ul>
                <li>Estado:{{ status }}</li>
                <li>Especie:{{ species }}</li>
                <li>Genero:{{ gender }}</li>
            </ul>
        </v-card-text>
        
        <v-card-actions>
            <!-- <v-btn @click="toggleLike"  :class="btnStatus">
                <span v-text="like ? 'Favorita ' : 'Agregar a favoritos '"></span>
                 <v-icon>mdi-thumb-up</v-icon>
            </v-btn> -->
        </v-card-actions>
    </v-card>
</template>
<script>

export default {
    name: 'card',

    props: {
        id: {
            type: Number,
            required: true
        },
        name: {
            type: String,
            required: true
        },
        status: {
            type: String,
            default: 'desconocido'
        },
        species: {
            type: String,
            default: 'desconocido'
        },
        gender: {
            type: String,
            default: 'desconocido'
        },
        image: {
            type: String,
            required: true
        }
    },
    methods: {
        
    },

    data:()=>({
       
       
    }),
    
 

}

</script>
<style>
 
</style>