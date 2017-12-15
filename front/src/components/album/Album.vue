<template>
  <div class="card-content">
    <a @click="select">
      <article class="media">
        <figure class="media-left">
          <p class="image is-64x64">
            <img :src="data.cover"/>
          </p>
        </figure>
        <div class="media-content">
          <div class="content">
            <p><strong>{{ data.name }}</strong></p>
          </div>
        </div>
      </article>
    </a>
  </div>
</template>

<script>
  export default {
    props: ['data'],
    methods: {
      select () {
        const SONG_URL = '/v1/spotify/albums/'
        var url = SONG_URL + this.data.id
        var vm = this

        this.$http.get(url)
          .then(response => {
            var json = response.data
            var songs = json.map(s => {
              var song = { id: s.id, title: s.name, track: s.track_number }
              return song
            })
            vm.$emit('selected', songs)
          })
      }
    }
  }
</script>
