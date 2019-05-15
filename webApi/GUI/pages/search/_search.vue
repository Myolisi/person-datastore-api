<template>
  <section>
      
      <div class="uk-flex uk-flex-center uk-margin-xlarge-left">
	    <form class="uk-search uk-search-navbar uk-background-muted">
	      <a class=" uk-form-icon uk-search-icon-flip" uk-search-icon v-on:click.prevent="submit"></a>
	      <input class="uk-search-input uk-padding-small" v-on:keydown.enter.prevent="submit" placeholder="search" ref="searchField" v-model="searchValue" name="">
	    </form>
	  </div>

      <div v-if="isSearching == true" class="uk-float uk-flex uk-flex-center uk-margin-bottom">
      	    <!-- <span uk-spinner="ratio: 3"></span> -->
      	    <img src="https://data.whicdn.com/images/265718366/original.gif">
      </div>

		<div v-else> 
			<div v-if="$store.state.searchResult.length > 0" class="uk-container uk-child-width-1-2@m uk-margin-large-top ">
				<h4>Search results for:  <b>"{{$route.params.search}}"</b></h4>
				<div  class="uk-card uk-card-body" v-for="items in $store.state.searchResult">
				    <h3 class="uk-card-title">
				        	{{items.firstName}} 
				        	{{items.secondName}}
				        	{{items.thirdName }}
			                {{items.surname}}
			            <button class=" uk-button uk-button-danger uk-button-small uk-float-right" v-on:click.prevent="getUser(items.id)">View</button>
			        </h3>
				        <p>Identity Number: {{items.identifier}}</p>
				   </div>
			</div>	
		
	<div v-else class="uk-container uk-child-width-1-1@m uk-margin-large-top ">
		<h4 class="uk-text-center uk-margin-medium-left">Sorry <b>"{{$route.params.search}}"</b> could not be found</h4>
	</div>	
	</div>

  </section>
</template>

<script>

import PersonsList from '@/components/PersonsList'
import searchPerson from '@/components/searchPerson'
import search from '@/mixin/search'

export default {
  mixins:[search],
  middleware: 'searchResults',
  component:{
  	'person':PersonsList,
  	'search' : searchPerson
  },
  data: function(){
  	return{
  		searchValue:'',
  		telephones:[],
  		searchString:'',
  		isSearching: false
  	}
  },
  watch:{

  },
  methods:{
  	/*searchData(){
  		let extractId = this.$store.state.searchResult.forEach(item => {
  			this.id = item.id; 
  			return this.id
  		});

  	},*/
  	viewData(){
		this.$router.push(`/view/${this.searchValue}`)
  	},
  	getUser(param){
      this.$router.push(`../view/${param}`)  
    },
    submit(){
    	if (this.$refs.searchField.value !== '' ) {
    		this.isSearching = true    
		    this.$router.push(`${this.searchValue}`)
		    this.searchString = ''
		}
		//delay loading bar

    	setTimeout(() =>{
    	 		this.isSearching = false
    	}, 800)
    	
    }
      
  }
}


</script>

<style>

</style>


