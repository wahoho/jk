<template>
  <div class="box">
    <div class="content has-text-centered">
      <iframe type="text/html" width="320" height="240" :src="url" frameborder="0"></iframe>
      <h5 class="subtitle">
        <a :href="youtubeUrl" target="_blank">Youtubeで見る</a>
      </h5>
    </div>
  </div>
</template>

<script>
  export default {
    computed: {
      url () {
        return 'http://www.youtube.com/embed/' + this.track + '?enablejsapi=1&origin=http://example.com'
      },
      youtubeUrl () {
        return 'https://www.youtube.com/watch?v=' + this.track
      }
    },
    props: ['track']
  }
</script>

<style>
  .box {
    padding: 1em;
  }
</style>
