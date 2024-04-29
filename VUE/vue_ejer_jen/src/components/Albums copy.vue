<template>
  <v-container>
    <v-card>
      <v-card-title>Albums</v-card-title>
      <v-card-text>
        <template>
          <v-simple-table>
            <template v-slot:default>
              <thead>
                <tr>
                  <th class="text-left">
                    Name
                  </th>
                  <th class="text-left">
                    Actions
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr v-for=" (album, key) in $store.state.albums" :key="key">
                  <td width="80%">{{ album }}</td>
                  <td> <v-btn icon small class="mr-2" @click="editAlbum(album)">
                      <v-icon>mdi-pencil</v-icon>
                    </v-btn>
                    <v-btn icon small @click="deleteAlbum(album)">
                      <v-icon>mdi-delete</v-icon>
                    </v-btn>
                  </td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
        </template>
      </v-card-text>
      <v-card-actions>
        <v-row >
          <v-col class="align-content-end">
             <v-btn color="primary" @click="openAddAlbumDialog">Agregar Album</v-btn>
          </v-col>
          <v-col>
            <v-select flat :items="$store.state.artists" label="Artistas" solo></v-select>
          </v-col>
        </v-row>
      </v-card-actions>
    </v-card>

    <generic_dialog :dialog-visible="addAlbumDialog" :title="'Agregar Album'">
      <template #content>
        <v-text-field label="Nombre" v-model="newAlbumName" />
      </template>
      <template #actions>
        <v-btn @click="addAlbum" color="blue darken-1" text>Guardar</v-btn>
        <v-btn @click="closeAddAlbumDialog" color="blue darken-1" text>Cancelar</v-btn>
      </template>
    </generic_dialog>

    <generic_dialog :dialog-visible="editAlbumDialog" :title="'Editar Album'">
      <template #content>
        <v-text-field label="Nombre" v-model="editAlbumName" />
      </template>
      <template #actions>
        <v-btn @click="saveEditedAlbum" color="blue darken-1" text>Guardar</v-btn>
        <v-btn @click="closeEditAlbumDialog" color="blue darken-1" text>Cancelar</v-btn>
      </template>
    </generic_dialog>

  </v-container>
</template>

<script>

import generic_dialog from '@/components/GenericDialog.vue'
const type='albums'
export default {

  data() {
    return {
      newAlbumName: '',
      oldAlbumName: '',
      editAlbumName: '',
      addAlbumDialog: false,
      editAlbumDialog: false,
      items: ''
    };
  },

  methods: {
    
    addAlbum() {
      if (this.newAlbumName) {
        this.$store.dispatch('addAction', {type:type, newData:this.newAlbumName});
        this.newAlbumName = '';
        this.closeAddAlbumDialog();
      }
    },
    editAlbum(AlbumName) {
      // console.log(AlbumName)
      this.oldAlbumName = AlbumName;
      this.editAlbumDialog = true;
    },
    saveEditedAlbum() {
      if (this.editAlbumName) {
        //   console.log(this.oldAlbumName,this.editAlbumName)
        this.$store.dispatch('editAction', { type:type, oldData: this.oldAlbumName, newData: this.editAlbumName });
        this.editAlbumName = '';
        this.closeEditAlbumDialog();
      }
    },
    deleteAlbum(AlbumName) {
      this.$store.dispatch('deleteAction', { type:type, oldData: AlbumName });
    },
    openAddAlbumDialog() {
      this.addAlbumDialog = true;
    },
    closeAddAlbumDialog() {
      this.addAlbumDialog = false;
    },
    closeEditAlbumDialog() {
      this.editAlbumDialog = false;
    },
  },
  components: {
    generic_dialog
  }
};
</script>

<style>
v-select{
  width: 60px;
  height: 20px;
}

</style>
