<template>
  <div>
    <span>
      <a @click="select"><strong>{{ data.name }}</strong></a>
    </span>
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
