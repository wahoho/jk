<template>
  <div>
    <section class="hero is-info">
      <div class="hero-body">
        <div class="container has-text-centered">
          <h3 class="title">
            Youtube関連動画
          </h3>
        </div>
      </div>
    </section>
    <section class="section">
      <div class="outer">
        <div v-for="row in videos">
          <div class="inner columns">
            <div v-for="video in row" class="column is-4">
              <youtube-video :track="video"></youtube-video>
            </div>
          </div>
        </div>
      </div>
    </section>
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
        ['6NeIih9sQQ4', 'L0MK7qz13bU', 'vsl3gBVO2k4'],
        ['CrXM5mBBtso', 'TO_kCtqSyyo', 'xbIR2m9TES0']
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
