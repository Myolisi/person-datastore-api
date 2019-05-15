<template>
<div class="uk-container uk-margin-large ">
	<div v-if="isAddingPeron === true" class="personal_information">
	<div class=" person" >
		<form class="uk-child-width-1-3 ">
			<div>
				<label>First Name</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="firstName" for="" type="text" class="uk-input" :class="{'uk-form-danger': danger}" name="">
					<validate v-if="firstName == ''" :message= "message"></validate>
				</div>
			</div>
			

			<div>
				<label>Second Name</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="secondName" type="text" class="uk-input" :class="{'uk-form-danger': danger}"  name="">
					<validate v-if="secondName == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Third Name</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="thirdName" type="text" class="uk-input" :class="{'uk-form-danger': danger}" name="">
					<validate v-if="thirdName == ''"  :message= "message"></validate>
				</div>
			</div>
			

			<div>
				<label>Surname</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="surname" type="text" class="uk-input" :class="{'uk-form-danger': danger}" name="">
					<validate v-if="surname == ''" :message= "message"></validate>
				</div>
			</div>
			

			<div>
				<label>identifier</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="identifier" type="text" class="uk-input" :class="{'uk-form-danger': danger}" name="">
					<validate v-if="identifier == ''" :message= "message"></validate>
				</div>
			</div>
			

			<div>
				<label>Passport</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<select class="uk-select" v-model="isPassport">
		                <option value="" selected disabled hidden >No</option>
		                <option>Yes</option>
		                <option>No</option>
		            </select>
	        	</div>
			</div>

			
		</form>
	</div>


	<div class="uk-margin-large country">
		<h5>Country</h5>
		<form class="uk-child-width-1-3">
			<div>
				<label>Country Code</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input style="text-transform:uppercase" maxlength="3" size="3" v-model="code" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}"><br>
					<validate v-if="identifier == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Name</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="name" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}" >
					<validate v-if="identifier == ''" :message= "message"></validate>
					<button false v-on:click.prevent="addCountry" class=" uk-margin-top uk-button uk-button-secondary uk-button-small">Add</button>
				</div>
			</div>
			
		</form>
	</div>
    </div><!--Personal Information-->

	<div  v-else="isAddingPeron = false" class="telephone_Address">
	<div class="uk-margin-large Address">
		<h5>Address</h5>
		<form class="uk-child-width-1-3">
			
			<div>
				<label>Line 1</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line1" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}">
					<validate v-if="line1 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Line 2</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line2" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}">
					<validate v-if="line2 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Line 3</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line3" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}">
					<validate v-if="line3 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Line 4</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line4" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}">
					<validate v-if="line4 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Postal Code</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="postalCode" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}">
					<validate v-if="postalCode == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Address Type</label>
				<div class="uk-form-controls uk-margin-small-bottom">
		            <select class="uk-select" v-model="addressTypeSelected">
		                <option>Postal</option>
		                <option>Home</option>
		            </select>
            	</div><br>
			</div>
			<div v-if="isAddressAdded === true" class="uk-alert-success" uk-alert>
                <a class="uk-alert-close" @click="isAddressAdded = false" uk-close></a>
                <p>Telephone Added.</p>
            </div>
			<button v-on:click.prevent="addAddress" class=" uk-button uk-button-secondary uk-button-small">Add</button>
		</form>
	</div>

	<div class="uk-margin-large Telephone">
		<h5>Telephone</h5>
		<form class="uk-child-width-1-3">
			<div>
				<label>Number</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="personTelephone" type="text" class="uk-input" name="" :class="{'uk-form-danger': danger}">
					<validate v-if="postalCode == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Telephone Type</label>
				<div class="uk-form-controls uk-margin-small-bottom">
		            <select class="uk-select" v-model="telephoneTypeSelected" >
		                <option disabled>Select Telephone</option>
		                <option>Cell Number</option>
		                <option>Work</option>
		                <option>Home</option>
		            </select>
            	</div><br>
			</div>
			<div v-if="isTelephoneAdded === true" class="uk-alert-success" uk-alert>
                <a class="uk-alert-close" @click="isTelephoneAdded = false" uk-close></a>
                <p>Telephone Added.</p>
            </div>
			<button v-on:click.prevent="addTelephone" class=" uk-button uk-button-secondary uk-button-small">Add</button>
		</form>
	</div>
	</div> <!--Telephone_address-->

</div>

</template>

<script>

import PersonsList from '@/components/PersonsList'
import axios from 'axios'
import inputValidator from '@/components/inputValidator'
import {mapGetters} from 'vuex'

export default {

	props:[
		
	],
	computed:{
		...mapGetters([
		])
	},
	components:{
		'validate': inputValidator
	},
  data: function(){
    return{
	    countryList:[],
	    telephoneList:[],
	    personList:[],
	    addressList:[],
	    personAddressList:[], 
	    personTelephone:'',
	      
	    //telephone
	    telephoneTypeSelected:'',
	    telephoneType:'',
	    personTelephone:'',

	    //address
		line1:'',
		line2:'',
		line3:'',
		line4:'',
		postalCode:'',
		addressTypeSelected:'',
		addressType:'',

		//country
		code: '',
	    name :'',


	    //person
	    firstName :'' ,
		secondName : '',
		thirdName : '',
		surname : '',
		identifier : '',
		CountryId : '',
		isPassport:'',
		passport :  false,

		personID:'',
		addressID:'',
		telephoneID:'',

		isAddingPeron:true,
		operation:'',

		message:' ',
		danger: false,
		isAddressAdded: false,
		isTelephoneAdded: false,
		isPersonAdded: false
       }
  },
  watch:{
  	telephoneTypeSelected: function(){
  		if (this.telephoneTypeSelected === 'Cell Number' ) {
  			this.telephoneType = 1
  		}else if (this.telephoneTypeSelected === 'Work') {
  			this.telephoneType = 2
  		}else if (this.telephoneTypeSelected === 'Home') {
  			this.telephoneType = 3
  		}
  	},
  	addressTypeSelected: function(){
  		if (this.addressTypeSelected === 'Postal' ) {
  			this.addressType = 1
  		} else if (this.addressTypeSelected === 'Home') {
  			this.addressType = 2
  		}
  	},
  	isPassport: function(){
  		if (this.isPassport === 'Yes' ) {
  			this.passport = true
  		} else if (this.isPassport === 'No') {
  			this.passport = false
  		}
  	}
  },
  methods:{
    addTelephone(){
    	let vm = this
				const personTelephoneInfo = { 
					fkTelephoneTypeId: this.telephoneType, 
					number: this.personTelephone 
				}
				console.log(personTelephoneInfo)

    	if (this.this.personTelephone === '') {
    		this.message = 'required field*'
      		this.danger = true
      		this.isTelephoneAdded = false
    	}else{
			    

			   fetch('/api/telephone', {
			  		method: 'post',
			       
			       body: JSON.stringify({ 
					fkTelephoneTypeId: vm.telephoneType, 
					number: vm.personTelephone 
				})

				}).then(response => {
					fetch('/api/telephones')
							  .then(function(response) {
							    return response.json();
							   
							  }).then(function(response) {
							  	  vm.telephoneID = response[response.length - 1].id
								  	  fetch('/api/personTelephone', {
								  		method: 'post',
								       
								       body: JSON.stringify({ 
											fkPersonId : vm.personID,
											fkTelephoneId : vm.telephoneID,
											current : true
									})

									}).then(response => {
										vm.isTelephoneAdded = true
									})

							  })
				});
			}    
    },
    addAddress(){

    	if (this.line1 === '' || this.line2 === '' || this.line3 === ''|| this.line4 === '' || this.postalCode === '' ||this.addressType === '') {
    		this.message = 'required field*'
      		this.danger = true
      		this.isAddressAdded = false
    	}else{
    		let vm = this
		       fetch('/api/address', {
		  	   method: 'post',
		       
		       body: JSON.stringify({ 
					line1 : this.line1,
					line2: this.line2,
					line3 : this.line3,
					line4 : this.line4,
					postalCode : this.postalCode,
					fkAddressTypeId : this.addressType
				})

			}).then(response => {
				console.log(response)
				fetch('/api/addresses')
				  .then(function(response) {
				    return response.json();
				   
				  }).then(function(response) {
				  	  vm.addressID = response[response.length - 1].id
					  	  fetch('/api/personAddress', {
					  		method: 'post',
					       
						       body: JSON.stringify({ 
									fkPersonId : vm.personID,
									fkAddressId : vm.addressID,
									current : true
							    })
						}).then(response => {
							this.isAddressAdded = true
						})

				  })
			});
    	}
       
    	this.message = ''
      	this.danger = false
    },
      addCountry(){

      	if(this.code === '' || this.name === '' || this.firstName === ''|| this.secondName === ''|| this.thirdName === ''|| this.surname === '' || this.identifier === ''){

      		this.message = 'required field*'
      		this.danger = true
      		this.isPersonAdded = false

      	}else{

      	axios('/api/country', {
  	   	   method: 'post',
       
	       body: JSON.stringify({ 
				code : this.code,
				name: this.name,
			})

			}).then(response => {

				let vm = this
				fetch('/api/countries')
				  .then(function(response) {
				    return response.json();
				   
				  })
				  .then(function(myJson) {
				  	vm.CountryId = myJson[myJson.length -1].id
				    fetch('/api/person', {
		  	   		method: 'post',
		       
		       		body: JSON.stringify({ 
						  firstName : vm.firstName ,
						  secondName : vm.secondName ,
						  thirdName : vm.thirdName,
						  surname : vm.surname,
						  identifier : vm.identifier ,
						  fkCountryId : vm.CountryId,
						  passport : vm.passport
				    })

					}).then(response => {
						fetch('/api/persons')
						  .then(function(response) {
						    return response.json();
						   
						  }).then(function(response) {
							  	vm.personID = response[response.length - 1].id
								vm.isPersonAdded = true 
						  })	

					});
				 });
			});
		   
		   this.isAddingPeron = false;
		   this.message = ''
      	   this.danger = false

      	}
    },

    getUser(param){
      this.$router.push(`view/${this.personID}`)  

    }

  }
}


</script>

<style>

</style>
