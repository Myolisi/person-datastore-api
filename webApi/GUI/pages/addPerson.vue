<template>
<div class="uk-container uk-margin-large ">
	<div v-show="isPersonAdded === true" class="uk-alert-success uk-flex uk-width-1-1" uk-alert>
		<a class="uk-alert-close" uk-close></a>
	    <p>Persononal Information Saved.</p>
	</div>
	
	<div v-show="isAddingPeron === true" class="personal_information">
	<div class=" person" >
		<h5>Personal Information <hr></h5>
		<form class="uk-child-width-1-3 ">
			<div>

				<label>First Name</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="firstName" for="" type="text" class="uk-input" name="">
					<validate v-if="firstName == ''" :message= "message"></validate>
				</div>
			</div>
			

			<div>
				<label>Second Name</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="secondName" type="text" class="uk-input" name="">
					<validate v-if="secondName == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Third Name</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="thirdName" type="text" class="uk-input" name="">
					<validate v-if="thirdName == ''"  :message= "message"></validate>
				</div>
			</div>
			

			<div>
				<label>Surname</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="surname" type="text" class="uk-input" name="">
					<validate v-if="surname == ''" :message= "message"></validate>
				</div>
			</div>
			

			<div>
				<label>identifier</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="identifier" type="text" class="uk-input" name="">
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
				<div>
					<h3>{{countries}}</h3>
					<select class="uk-select" v-model="name" > 
						<option v-for="items in getCountryList">{{items.name}}</option>
					</select> 
				</div>
				<button false v-on:click.prevent="addCountry" class=" uk-margin-top uk-button uk-button-primary uk-button-small">Add</button>

				<div v-show="isExist === true" class="uk-alert-danger" uk-alert>
				    <a class="uk-alert-close" uk-close></a>
				    <p>User Already exists.</p>
				</div>
			</div>
	
		</form>
	</div>
    </div><!--Personal Information-->

	<div v-show="isAddingPeron === false" class="telephone_Address">
	<div class="uk-margin-large Address">
		<h5>Contact Information <hr></h5>
		<h5>Address</h5>
		<form class="uk-child-width-1-3">
			
			<div>
				<label>Line 1</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line1" type="text" class="uk-input" name="">
					<validate v-if="line1 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Line 2</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line2" type="text" class="uk-input" name="">
					<validate v-if="line2 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Line 3</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line3" type="text" class="uk-input" name="">
					<validate v-if="line3 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Line 4</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="line4" type="text" class="uk-input" name="">
					<validate v-if="line4 == ''" :message= "message"></validate>
				</div>
			</div>
			
			<div>
				<label>Postal Code</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="postalCode" type="text" class="uk-input" name="">
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
			<div v-show="isAddressAdded === true" class="uk-alert-success" uk-alert>
                <a class="uk-alert-close" @click="isAddressAdded = false" uk-close></a>
                <p>Address Added.</p>
            </div>
		</form>
		<button v-on:click.prevent="addAddress" class=" uk-button uk-button-primary uk-button-small">Add</button>
	</div>

	<div class="uk-margin-large Telephone">
		<h5>Telephone</h5>
		<form class="uk-child-width-1-3">
			<div>
				<label>Number</label>
				<div class="uk-form-controls uk-margin-small-bottom">
					<input v-model="personTelephone" type="text" class="uk-input" name="">
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
			<div v-show="isTelephoneAdded === true" class="uk-alert-success" uk-alert>
                <a class="uk-alert-close" @click="isTelephoneAdded = false" uk-close></a>
                <p>Telephone Added.</p>
            </div>
		</form>
		<button v-on:click.prevent="addTelephone" class=" uk-button uk-button-primary uk-button-small">Add</button>
	</div>
	</div> <!--Telephone_address-->
	
	<!--<progress id="js-progressbar" class="uk-progress" v-bind:value="f" max="100"></progress>
	<button @click="ff"> add </button>
	<script type=" ">
	</script>-->

</div>

</template>

<script>

import PersonsList from '@/components/PersonsList'
import axios from 'axios'
import inputValidator from '@/components/inputValidator'
import {mapGetters} from 'vuex'
import add from '@/mixin/add'

export default {
	mixins:[add],
	data: function(){
		return{
			f:10
		}
	},
	method:{
		ff(){
			this.f =40
		}
	}
}
</script>

<style>

</style>
