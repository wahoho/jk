<template>
  <div class="column">
    <div v-for="album in albums" class="card">
      <div class="card-content">
        <!--
        <div>
          <span><strong>{{ album.title }}</strong></span>
        </div>
        <div>
          <p>{{ album.description }}</p>
        </div>
        -->
        <article class="media">
          <figure class="media-left">
            <p class="image is-64x64">
              <img :src="album.cover"/>
            </p>
          </figure>
          <div class="media-content">
            <div class="content">
              <p><strong>{{ album.name }}</strong></p>
            </div>
          </div>
        </article>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    props: ['albums'],
    created () {

    }
  }
</script>

<style scoped>
  .column {
    overflow-y: auto;
    max-height: 585px;
  }
</style>
