<template>
	<div class="uk-child-width-1-1 uk-flex-center" uk-grid>
		<label>{{message}}</label>
   </div>
</template>


<script>
import axios from 'axios'
	export default{
		props: ['message'],
		data:function(){
			return {
				
			}
		}
}
</script>

<style scoped>

label{
	font-size: 10px;
	color: red;
}


</style>