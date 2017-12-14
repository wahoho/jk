<template>
  <div class="outer">
    <div class="inner columns">
      <div v-for="row in videos">
        <div v-for="video in row" class="column">
          <youtube-video :track="video"></youtube-video>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import YoutubeVideo from './YoutubeVideo'

  export default {
    components: {
      YoutubeVideo
    },
    data () {
      var youtubeVids = [
        ['6NeIih9sQQ4', 'L0MK7qz13bU'],
        ['CrXM5mBBtso', 'TO_kCtqSyyo'],
        ['vsl3gBVO2k4', 'xbIR2m9TES0']
      ]

      return {
        videos: youtubeVids
      }
    },
    computed: {
      url (id) {

      }
    }
  }
</script>
