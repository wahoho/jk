<template>
  <div>
    <iframe type="text/html" width="320" height="240" :src="url" frameborder="0"></iframe>
  </div>
</template>

<script>
  export default {
    computed: {
      url () {
        console.log(this.track)
        return 'http://www.youtube.com/embed/' + this.track + '?enablejsapi=1&origin=http://example.com'
      }
    },
    props: ['track']
  }
</script>
