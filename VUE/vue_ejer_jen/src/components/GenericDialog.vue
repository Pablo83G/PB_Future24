<template>
  <v-dialog v-model="dialogVisible" width="500" persistent>
    <v-card>
      <v-card-title :title="title">{{ title }}</v-card-title>
      <v-card-text>
        <slot name="content"></slot>
      </v-card-text>
      <v-card-actions>
        <slot name="actions"></slot>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
<script>
export default {
  name: 'generic_dialog',
  // Props para manejar la visibilidad y el titulo del dialogo
  data: () => ({
    dialogVisibleLocal: null // Establece un valor inicial 
  }),
  props: {
    dialogVisible: {
      type: Boolean,
      required: true
    },
    title: {
      type: String,
      required: true
    }
  },
  // Slots para inyectar el contenido y las acciones segun el caso
  slots: {
    content: 'default',
    actions: 'default'
  }
};
</script>