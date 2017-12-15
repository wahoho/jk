<template>
  <div class="column">
    <div v-for="song in songs" class="card">
      <song :data="song" v-on:selected="select"></song>
    </div>
  </div>
</template>

<script>
  import Song from './Song'
  export default {
    components: {
      Song
    },
    props: ['songs'],
    methods: {
      select (song) {
        this.$emit('selected', song)
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
