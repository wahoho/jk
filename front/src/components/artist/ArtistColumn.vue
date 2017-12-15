<template>
  <div class="column">
    <div v-for="artist in artists" class="card">
      <div class="card-content">
        <artist :data="artist" v-on:selected="select"></artist>
      </div>
    </div>
  </div>
</template>

<script>
  import Artist from './Artist'

  export default {
    components: {
      Artist
    },
    props: ['artists'],
    methods: {
      select (artist) {
        this.$emit('selected', artist)
      }
    }
  }
</script>

<style scoped>
  .column {
    overflow-y: auto;
    max-height: 585px;
  }
</style>
