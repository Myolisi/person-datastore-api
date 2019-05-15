<template>
  <section>
  	<div class="uk-container">
      <h3>Hello</h3>
    </div>
  </section>
</template>
<script>


export default {
  props:['person', 'telephones', 'addresses' ],
   methods:{
    editUser(){
      this.$router.push(`/update/${this.$route.params.view}`)
    }
  }
}


</script>

<style>

.bg{
  background-color:#fff;
}

h5{
  font-family: Berlin Sans FB;
  font-size: 17px;
}
caption{
  background-color: #F3F9F6;
  padding:10px;
}

</style>
