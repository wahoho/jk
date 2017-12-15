<template>
  <div>
    <section class="section">
      <div class="container">
        <div class="content has-text-centered">
          <iframe :src="url" width="800" height="300" frameborder="1" allowtransparency="true"></iframe>
        </div>
      </div>
      <br>
      <!--
      <div class="container">
        <video-suggestion></video-suggestion>
      </div>
      -->
    </section>
  </div>
</template>

<script>
  import VideoSuggestion from './VideoSuggestion'

  export default {
    components: {
      VideoSuggestion
    },
    props: ['song'],
    computed: {
      url () {
        return 'https://open.spotify.com/embed?uri=spotify%3Atrack%3A' + this.song.id + '&theme=white'
      }
    }
  }
</script>
