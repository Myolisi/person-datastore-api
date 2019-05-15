<template>
  <section>
  	<div class="uk-container">
      
      <viewPerson
        v-bind:person = "$store.state.viewedPerson"
        v-bind:country = "$store.state.country"
        v-bind:telephones = "$store.state.telephones"
        v-bind:addresses = "$store.state.addresses"
      />
    </div>
  </section>
</template>
<script>

import view from '@/components/view'
import axios from 'axios'

export default {
  middleware: 'getPerson',
  components: {
    'viewPerson':view
  },
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

</style>
