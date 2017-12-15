<template>
  <div class="column">
    <div v-for="song in songs" class="card">
      <div class="card-content">
        <div>
          <span><strong>{{ song.title }}</strong></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    props: ['songs']
  }
</script>
