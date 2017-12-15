<template>
  <div class="column">
    <div v-for="album in albums" class="card">
      <div class="card-content">
        <div>
          <span><strong>{{ album.title }}</strong></span>
        </div>
        <div>
          <p>{{ album.description }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    props: ['albums']
  }
</script>
