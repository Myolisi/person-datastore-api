<template>
	<div class="uk-child-width-1-1 uk-flex-center" uk-grid>
		<div class="uk-container uk-margin-large-top ">
		 <table class="uk-table uk-table-hover">
	      <thead>
	        <td><h5>Full Name</h5></td>
	        <td><h5>ID/Passport</h5></td>
	        <td></td>
	      </thead>
	      <tbody v-for="items in persons">
	          <tr>
	            <td>
	              	<h5>
	              		<h2>{{items.id}}</h2>
	              		{{items.firstName}} {{items.secondName}} {{items.thirdName}}
	                    {{items.surname}}
	                </h5>
	            </td>

	              <td>{{items.identifier}}</td>
	              <td><button v-on:click="submit(items.id)" class="uk-button uk-button-primary uk-button-small update">Update</button></td>
	          </tr>

	      </tbody>
	     </table>
	 </div>
 </div>
</template>


<script>
import axios from 'axios'
	export default{
		props: ['persons', 'id', 'submit'],
		data:function(){
			return {
				telephones:[]
			}
		},
	  methods:{
	    submit(param){
	    	let vm = this
	      axios.get('/api/person/' + param)
		    .then((response) => {
		      response.data.forEach(function(item) {
                  vm.telephones.push(item.firstName + ' ' + item.secondName + ' ' + item.surname);
                  
           		})
		      return console.log(response.data)
		    })
		    
	    }
	}
}
</script>

<style scoped>

thead td h5{
	font-weight: bold;
	font-family: Century Gothic;

}

.update{
	background-color: #23A8EA;
}

tbody tr td, h4{
	font-family: Berlin Sans FB;


}

</style>