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
                    Id
                  </th>
                  <th class="text-left">
                    Name
                  </th>
                  <th class="text-left">
                    Actions
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr v-for=" (artist) in $store.state.artists" :key="artist.id">
                  <td width="10%">{{ artist.id }}</td>
                  <td width="70%">{{ artist.name }}</td>
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
      id:1,
      newArtistName: '',
      oldArtist: '',
      editArtistName: '',
      addArtistDialog: false,
      editArtistDialog: false,
    };
  },

  methods: {
    addArtist() {
      if (this.newArtistName) {
        const artist={
          id:this.id,
          name:this.newArtistName
        }
        this.$store.dispatch('addAction', {type:type, newObject:artist});
        this.newArtistName = '';
        this.closeAddArtistDialog();
        this.id++
      }
    },
    editArtist(artist) {
      // console.log(artistName)
      this.oldArtist = artist;
      this.editArtistDialog = true;
    },
    saveEditedArtist() {
      if (this.editArtistName) {
        //   console.log(this.oldArtistName,this.editArtistName)
        this.$store.dispatch('editAction', { type:type, oldObject: this.oldArtist, newName: this.editArtistName });
        this.editArtistName = '';
        this.closeEditArtistDialog();
      }
    },
    deleteArtist(artist) {
      this.$store.dispatch('deleteAction', { type:type, oldObject: artist });
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
