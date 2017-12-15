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
    created () {
      // this.searchYoutube()
    },
    methods: {
      /*
      searchYoutube () {
        var key = 'AIzaSyCAFzN8rqVP_tSlab2cI8eaHtruYCw0fvI'
        var query = 'akb48'
        this.$http.get('https://www.googleapis.com/youtube/v3/search?part=snippet&q=' + query + '&key=' + key)
          .then(response => {
            var data = response.data
            console.log(data)
          })
          .catch(e => {
            console.log(e)
          })
      }
      */
    }
  }
</script>
