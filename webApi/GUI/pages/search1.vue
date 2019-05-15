<template>
	<section>
		<div class="uk-container">
			
			<div v-if="isAddingPerson === true">
		        <div class="uk-card uk-card-default uk-card-body uk-margin-bottom">
		            <h3 class="uk-card-title">Person</h3>
		            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		        </div>
    		</div>
			
			<div v-else-if="isAddingPerson === false">
		        <div class="uk-card uk-card-default uk-card-body">
		            <h3 class="uk-card-title">Telephone and address</h3>
		            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		        </div>
    		</div>
		
		
		<a v-on:click="update" class="uk-button-text">update</a>
			
		</div>
	</section>
</template>

<script>
	import axios from 'Axios'
	export default{
		data: function(){
			return{
				isAddingPerson:true
			}
		},
		methods:{
			update(){
			
				setTimeout(() =>{
					this.isAddingPerson = false
				}, 1300)
				console.log('Updated!')
			}
		}

	}

</script>