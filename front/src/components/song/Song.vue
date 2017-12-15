<template>
  <div class="card-content">
    <a @click="select">
      <div>
        <p>
          <span><strong>{{ data.title }}</strong></span>
        </p>
        <p>
          Track {{ data.track }}
        </p>
      </div>
    </a>
  </div>
</template>

<script>
  export default {
    props: ['data'],
    methods: {
      select () {
        this.$emit('selected', this.data)
      }
    }
  }
</script>
