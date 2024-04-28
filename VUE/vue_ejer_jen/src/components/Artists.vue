<template>
  <v-container>
    <v-card>
      <v-card-title>Artistas</v-card-title>
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
                <tr v-for=" (artist, key) in $store.state.artists" :key="key">
                  <td width="80%">{{ artist }}</td>
                  <td shrink: true> <v-btn icon small  @click="editArtist(artist)">
                      <v-icon>mdi-pencil</v-icon>
                    </v-btn>
                    <v-btn icon small @click="deleteArtist(artist)">
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
        <v-btn color="primary" @click="openAddArtistDialog">Agregar Artista</v-btn>
      </v-card-actions>
    </v-card>


    <generic_dialog :dialog-visible="addArtistDialog" :title="'Agregar Artista'">
      <template #content>
        <v-text-field label="Nombre" v-model="newArtistName" />
      </template>
      <template #actions>
        <v-btn  color="blue darken-1"
                text
                @click="addArtist">Guardar</v-btn>
        <v-btn  color="blue darken-1"
                text
        @click="closeAddArtistDialog">Cancelar</v-btn>
      </template>
    </generic_dialog>


    <generic_dialog :dialog-visible="editArtistDialog" :title="'Editar Artista'">
      <template #content>
        <v-text-field label="Nombre" v-model="editArtistName" />
      </template>
      <template #actions>
        <v-btn color="blue darken-1"
                text
                @click="saveEditedArtist">Guardar</v-btn>
        <v-btn color="blue darken-1"
                text
                @click="closeEditArtistDialog">Cancelar</v-btn>
      </template>
    </generic_dialog>

    
  </v-container>
</template>

<script>
import generic_dialog from '@/components/GenericDialog.vue'
const type='artists'
export default {

  data() {
    return {
      newArtistName: '',
      oldArtistName: '',
      editArtistName: '',
      addArtistDialog: false,
      editArtistDialog: false,
    };
  },

  methods: {
    addArtist() {
      if (this.newArtistName) {
        this.$store.dispatch('addAction', {type:type, newData:this.newArtistName});
        this.newArtistName = '';
        this.closeAddArtistDialog();
      }
    },
    editArtist(artistName) {
      // console.log(artistName)
      this.oldArtistName = artistName;
      this.editArtistDialog = true;
    },
    saveEditedArtist() {
      if (this.editArtistName) {
        //   console.log(this.oldArtistName,this.editArtistName)
        this.$store.dispatch('editAction', { type:type, oldData: this.oldArtistName, newData: this.editArtistName });
        this.editArtistName = '';
        this.closeEditArtistDialog();
      }
    },
    deleteArtist(artistName) {
      this.$store.dispatch('deleteAction', { type:type, oldData: artistName });
    },
    openAddArtistDialog() {
      this.addArtistDialog = true;
    },
    closeAddArtistDialog() {
      this.addArtistDialog = false;
    },
    closeEditArtistDialog() {
      this.editArtistDialog = false;
    },
  },
  components: {
    generic_dialog
  }
};
</script>

<style></style>
