<template>
  <div class="column">
    <div v-for="artist in artists" class="card">
      <div class="card-content">
        <div>
          <span><strong>{{ artist.name }}</strong></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    props: ['artists']
  }
</script>
