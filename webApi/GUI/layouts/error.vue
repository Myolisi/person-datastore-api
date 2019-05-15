<template>
  <div class="container">
    <div v-if="error.statusCode === 404">
      <h1 class="error">404</h1>
      <h1>Page not found</h1>
    </div>

    <h1 v-else>An error occured</h1>
    <nuxt-link to="/"><b>Home</b> </nuxt-link>
  </div>
</template>

<script>
export default {
  props: ['error']
}
</script>

<style scoped>
.container {
  font-family: sans-serif;
  padding-top: 10%;
  text-align: center;
}
h1 {
  font-size: 20px;
}
.error{
  color: red;
  font-family: Chiller;
  font-size: 80px;
}
</style>