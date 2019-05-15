<template> 
	<section> 
		<form class="uk-margin-remove-top uk-margin-remove-bottom uk-flex uk-flex-center uk-child-width-1-3" uk-grid>
	        <div>
	         <div class="uk-inline uk-margin-large-left">
	            <a class=" uk-form-icon" uk-icon="icon: search"  v-on:click.prevent="submit"></a>
	            <input class="uk-input uk-form-width-large" v-on:keydown.enter.prevent="submit" placeholder="search" v-model="searchValue" name="">
	        </div>
	      </div>
	    </form>
	</section>
</template>

<script>
	
	export default{
		props:['searchValue']
	}

</script>