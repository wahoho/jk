<template>
  <div class="column">
    <div v-for="album in albums" class="card">
      <album :data="album" v-on:selected="select"></album>
    </div>
  </div>
</template>

<script>
  import Album from './Album'

  export default {
    components: {
      Album
    },
    props: ['albums'],
    methods: {
      select (songs) {
        this.$emit('selected', songs)
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
