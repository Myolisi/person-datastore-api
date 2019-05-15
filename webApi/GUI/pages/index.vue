<template>
  <section>
<div>
    
    <!-- <search-bar v-bind:searchString = "searchValue" v-bind:submit = "submit"></search-bar> -->
    <!-- <person v-bind:persons ="$store.state.persons"></person> -->

  <div class="uk-flex uk-flex-center uk-margin-xlarge-left">
        <form class="uk-search uk-search-navbar uk-background-muted">
          <a class=" uk-form-icon uk-search-icon-flip" uk-search-icon v-on:click.prevent="submit"></a>
          <input class="uk-search-input uk-padding-small" v-on:keydown.enter.prevent="submit" placeholder="search" v-model="searchString" name="">
        </form>
    </div>

    <div class="uk-child-width-1-2 uk-margin-xlarge-left uk-flex-center">
    <div class="uk-container uk-margin-medium-top ">
     <table class="uk-table uk-table-hover">
        <thead>
          <td><h5>Full Name</h5></td>
          <td><h5>ID/Passport</h5></td>
          <td></td>
        </thead>
        <tbody v-for="items in personGetter">
            <tr>
                <td><h5>{{items.firstName}} {{items.secondName}} {{items.thirdName}}
                {{items.surname}}</h5>
            </td>
                <td>{{items.identifier}}</td>
                <td>
                  <nuxt-link :to="'/view/' + items.id" ><button class="uk-button-danger uk-button-small">View</button></nuxt-link>
                </td>
            </tr>
        </tbody>
       </table>
   </div>
 </div>
</div>

  </section>
</template>

<script>
import searchBar from '@/components/searchBar'
import PersonsList from '@/components/PersonsList'
import search from '@/mixin/search'
import axios from 'axios'
import { mapGetters } from 'vuex'


export default {
  middleware: 'getPersons',
  mixins:[search],
  
  computed: {
    ...mapGetters([
          'personGetter'
      ]),
    runGetter(){
      return console.log(this.personGetter)
    }
  },


  components: {
    'person':PersonsList,
    'searchBar': searchBar,
  }, 
  data: function(){
    return{
      searchString:'',
      getPerson:'',
    }
  },
  methods:{
    submit(){
         if (this.searchString !== '' ) {
        this.$router.push(`search/${this.searchString}`)
      }
    }
  }
  
}


</script>

<style>
.uk-search{
  margin-bottom: 10px !important;
  border-bottom: 1px solid;
  border-bottom-color: #F1F1F1;
}
</style>
