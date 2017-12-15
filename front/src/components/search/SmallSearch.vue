<template>
  <div class="field is-grouped">
    <p class="control">
      <input class="input" v-model="keyword" type="text" placeholder="アルバム・アティスト・曲名">
    </p>
    <p class="control">
      <a class="button is-info" @click="search">
        探す
      </a>
    </p>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        keyword: null
      }
    },
    methods: {
      search () {
        this.$router.push({ name: 'SearchResult', params: { keyword: this.keyword } })
      }
    }
  }
</script>
