<template>
  <div class="hero-body">
    <div class="container has-text-centered">
      <div class="column is-6 is-offset-3">
        <h1 class="title">
          何を聞きたい？
        </h1>
        <h2 class="subtitle">
          アルバム・アティスト・曲名を検索してみましょう
        </h2>
        <div class="box">
          <div class="field is-grouped">
            <p class="control is-expanded">
              <input class="input" v-model="keyword" type="text" placeholder="アルバム・アティスト・曲名">
            </p>
            <p class="control">
              <a class="button is-info" @click="search">
                探す
              </a>
            </p>
          </div>
        </div>
      </div>
    </div>
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
