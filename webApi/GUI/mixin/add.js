import PersonsList from '@/components/PersonsList'
import axios from 'axios'
import inputValidator from '@/components/inputValidator'
import {mapGetters} from 'vuex'
import allCountries from '@/mixin/allCountries'

export default {
	mixins:[allCountries],
	components:{
		'validate': inputValidator
	},
  data: function(){
    return{

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
		isPersonAdded: false,

		countryList:'',
		selectedCountry: '',
		countryCode:'',
		countryName:'',
		countries:'',
		countryInformation:'',

		isExist: false
       }
  },
  	computed:{
		...mapGetters([
			'getCountryList'
		])
	},
  watch:{

  	name:function(){
  		if (this.name !== '') {
  			console.log(this.name)

  			//get name for the selected country
  			let country = this.name
  			this.countryInformation = this.getCountryList.filter(function(items){
  				return items.name === country
  			})

  			//get code for the returned country
  			this.code = this.countryInformation[0].alpha3Code
  			console.log(this.code)
  		}
  	
  	},
  	telephoneTypeSelected: function(){
  		if (this.telephoneTypeSelected === 'Cell Number' ) {
  			this.telephoneType = 1
  		}else if (this.telephoneTypeSelected === 'Work') {
  			this.telephoneType = 2
  		}else if (this.telephoneTypeSelected === 'Home') {
  			this.telephoneType = 3
  		}
  	},
  	CountryName:function(){

  		
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

    	if (this.personTelephone === '') {
    		this.message = 'required field*'
      		this.danger = true
      		this.isTelephoneAdded = false
    	}else{
			    
			   axios({
			  		method: 'post',
			        url: '/api/telephone', 
			        data: { 
						fkTelephoneTypeId: vm.telephoneType, 
						number: vm.personTelephone 
					}
				}).then(response => {
					axios.get('/api/telephones')
					    .then(function(response) {
							vm.telephoneID = response.data[response.data.length - 1].id
						    axios({
								method: 'post',
								url: '/api/personTelephone',
								data: { 
								fkPersonId : vm.personID,
								fkTelephoneId : vm.telephoneID,
							    current : true
							}}
							).then(response => {
								vm.isTelephoneAdded = true
								setTimeout(()=>{
				      				vm.isTelephoneAdded = false
				      			}, 3000)
								vm.personTelephone = ''
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
		       axios({
		  	   method: 'post',
		       url: '/api/address',
		       data: { 
					line1 : this.line1,
					line2: this.line2,
					line3 : this.line3,
					line4 : this.line4,
					postalCode : this.postalCode,
					fkAddressTypeId : this.addressType
				}

			}).then(response => {
				console.log(response)
				axios('/api/addresses')
					.then(function(response) {
				  	  vm.addressID = response.data[response.data.length - 1].id
					  	  axios({
					  		method: 'post',
					  		url: '/api/personAddress',
						    data: { 
								fkPersonId : vm.personID,
								fkAddressId : vm.addressID,
								current : true
							}

						}).then(response => {
							vm.isAddressAdded = true
							setTimeout(()=>{
			      				vm.isAddressAdded = false
			      			}, 3000)
							 //clear fields
							 vm.line1 = ''
							 vm.line2 = ''
							 vm.line3 = ''
							 vm.line4 = ''
							 vm.postalCode = ''
							 vm.addressType = ''

						})

				  })
			});
    	}
       
    	this.message = ''
      	this.danger = false
    },
      addCountry(){

      	if( this.firstName === ''|| this.secondName === ''|| this.thirdName === ''|| this.surname === '' || this.identifier === ''){

      		this.message = 'required field*'
      		this.danger = true
      		this.isPersonAdded = false

      	}else{

      		let vm = this

      		axios.get(`/api/person/${vm.identifier}`)
      			.then(response =>{
      				vm.userSearch = response.data
	      			
	      			//check if user exists 
		      		if (vm.userSearch.length < 1){
		      			axios.get('/api/country/' + this.name)		   
					     .then(function(countrySearch) {
						
						if (countrySearch.data.length == 0) {
								axios({
						  	   	   method: 'post',
						       	   url: '/api/country',
							       data:{ 
										code : vm.code,
										name: vm.name,
									}

								}).then(response => {
									axios.get('/api/countries')
								    	.then(function(myJson) {
										  	vm.CountryId = myJson.data[myJson.data.length -1].id
										    axios({
									  	   		method: 'post',
									       		url:'/api/person',
									       		data: { 
													  firstName : vm.firstName ,
													  secondName : vm.secondName ,
													  thirdName : vm.thirdName,
													  surname : vm.surname,
													  identifier : vm.identifier ,
													  fkCountryId : vm.CountryId,
													  passport : vm.passport
											    }
											}).then(response => {
												axios.get('/api/persons')
												    .then(function(response) {
													  	vm.personID = response.data[response.data.length - 1].id
														vm.isPersonAdded = true 
														vm.isAddingPeron = false;
														
												  })	

											});
								 	});
							});

						} 
						//if country is already in the database then...
						else {
							vm.CountryId = countrySearch.data[0].id  //Take the Id of the country
							    axios({
						  	   		method: 'post',
						       		url:'/api/person',
						       		data: {
						       			
										  firstName : vm.firstName ,
										  secondName : vm.secondName ,
										  thirdName : vm.thirdName,
										  surname : vm.surname,
										  identifier : vm.identifier ,
										  fkCountryId : vm.CountryId,
										  passport : vm.passport
								    }

									}).then(response => {
										axios.get('/api/persons')
										  .then(function(response) {
										  	  vm.personID = response.data[response.data.length - 1].id
											  vm.isPersonAdded = true
											  vm.isAddingPeron = false; 
									});
								})
						}
					})
		      		
		      		}else {
		      			vm.isExist = true
		      			//custome notification
		      			setTimeout(()=>{
		      				vm.isExist = false
		      			}, 3000)
		      			vm.isAddingPeron = true;
		      		}
	      	})
		   
		   this.message = ''
      	   this.danger = false

      	}
    },

    getUser(param){
      this.$router.push(`view/${this.personID}`)  

    }
  }
  // asyncData (context) {
	 //    return axios.get(`https://restcountries.eu/rest/v2/all`)
	 //    .then((response) => {
	 //      return { data: response.data }
	 //    })
	 // }
}

