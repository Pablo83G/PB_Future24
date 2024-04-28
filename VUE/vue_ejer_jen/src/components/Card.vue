<template>
    <v-card :id="id" class="mx-auto my-12" max-width="374">
        <v-img height="auto" :src="image"></v-img>
        <v-card-title>{{name}}</v-card-title>
        <v-divider class="mx-4"></v-divider>
        <v-card-text>
            <ul>
                <li>Status:{{ status }}</li>
                <li>Species:{{ species }}</li>
                <li>Gender:{{ gender }}</li>
            </ul>
        </v-card-text>
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

    data:()=>({   }),
}

</script>
<style>
 
</style>