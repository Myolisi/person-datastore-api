<template>
  <section>
    <div class="uk-container">
     <h4>User Id: <span class="uk-label uk-label-success">{{$route.params.update}}</span></h4>
      
      <span @click.prevent="navigating" class="navigate uk-float-right uk-button uk-margin-remove-top">{{navigate}}</span>

      <div v-if="isAddingPeron === true" class="personal_information">
        <h3>Personal Information <hr></h3>
        <div class="uk-margin-small person " >
          <form class="uk-child-width-1-3 " v-for="personal in viewedPersonGetter">
            <div>
              <label>First Name</label>
              <div class="uk-form-controls">
                <input :value="personal.firstName" type="text" class="uk-input" name="" ref="firstName">
                <validate v-if="firstName == ''" :message= "message"></validate>
              </div>
            </div>
              
            <div>
              <label>Second Name</label>
              <div class="uk-form-controls">
                <input :value="personal.secondName" type="text" class="uk-input" name="" ref="secondName">
                <validate v-if="secondName == ''" :message= "message"></validate>
              </div>
            </div>
            
            <div>
              <label>Third Name</label> 
              <div class="uk-form-controls">
                <input :value="personal.thirdName" type="text" class="uk-input" name="" ref="thirdName">
                <validate v-if="thirdName == ''" :message= "message"></validate>
              </div>
            </div>
           

            <div>
              <label>Surname</label> 
              <div class="uk-form-controls">
                <input :value="personal.surname" type="text" class="uk-input" name="" ref="surname">
                <validate v-if="surname == ''" :message= "message"></validate>
              </div>
            </div>
           

            <div>
              <label>identifier</label>
              <div class="uk-form-controls">
                <input :value="personal.identifier" type="text" class="uk-input" name="" ref="identifier">
                <validate v-if="identifier == ''" :message= "message"></validate>
              </div>
            </div>
            

            <div>
              <label>Passport</label>
              <div class="uk-form-controls">
                <select class="uk-select" :value="personal.passport" ref="isPassport">
                  <option selected>{{personal.passport}}</option>
                  <option>false</option>
                </select>
            </div>
            </div>
            
          </form>
        </div>


        <div class="uk-margin-large country">
          <h3>Country <hr></h3>
          <form class="uk-child-width-1-3" v-for="personCountry in countryGetter" >
            <div>
              <label>Country Code</label>
              <div class="uk-form-controls">
                <input style="text-transform:uppercase" maxlength="3" size="3" :value="personCountry.code" type="text" class="uk-input" name="" ref="code">
                <validate v-if="code == ''" :message= "message"></validate>
              </div>
            </div>
            
            <div>
              <label>Name</label>
              <div class="uk-form-controls">
                <input :value="personCountry.name" type="text" class="uk-input" name="" ref="name">
                <validate v-if="name == ''" :message= "message"></validate>
                <input hidden="" disabled="" :value="personCountry.id" type="text" class="uk-input" name="" ref="id">
                <button false v-on:click.prevent="update" class=" uk-margin-top uk-button uk-button-primary uk-button-small">Update</button>
              </div>
            </div>
            
          </form>
          <div v-if="isPersonUpdated === true" class="uk-alert-success" uk-alert>
            <a class="uk-alert-close" uk-close></a>
            <p>Person Updated.</p>
          </div>
        </div>
    </div><!--Personal Information-->
  
  <div  v-if="isAddingPeron === false" class="telephone_Address">
    <h3>Address <hr></h3>
     <div class="uk-container "> 
          <div class="Address uk-accordion-content uk-background-muted uk-padding-small" v-for="address,index in addressesGetter">
            <ul uk-accordion>
              <li>
                  <a class="uk-accordion-title" href="#">Address {{index + 1}}</a>
                  <div class="uk-accordion-content">
                    <form class="uk-child-width-1-3">
                      <div>
                        <label>Line 1</label>
                        <div>
                          <input :value="address.line1" type="text" class="uk-input" name="" ref="line1">
                          <validate v-if="line1 == ''" :message= "message"></validate>
                        </div>
                      </div>
                      
                      
                      <div>
                        <label>Line 2</label>
                        <div>
                          <input :value="address.line2" type="text" class="uk-input" name="" ref="line2">
                          <validate v-if="line2 == ''" :message= "message"></validate>
                        </div>
                      </div>
                      
                      
                      <div>
                        <label>Line 3</label>
                        <div>
                          <input :value="address.line3" type="text" class="uk-input" name="" ref="line3">
                          <validate v-if="line3 == ''" :message= "message"></validate>
                        </div>
                      </div>
                      
                      
                      <div>
                        <label>Line 4</label>
                        <div>
                          <input :value="address.line4" type="text" class="uk-input" name="" ref="line4">
                          <validate v-if="line4 == ''" :message= "message"></validate>
                        </div>
                      </div>
                      
                      
                      <div>
                        <label>Postal Code</label>
                        <div>
                          <input :value="address.postalCode" type="text" class="uk-input" name="" ref="postalCode">
                          <validate v-if="postalCode == ''" :message= "message"></validate>
                        </div>
                      </div>
                      
                      
                      <div>
                        <label>Address Type</label>
                        <div>
                          <input hidden :value="address.id" type="text" class="uk-input" name="" ref="addressID">
                          <div class="uk-margin">
                              <select class="uk-select" ref="addressTypeSelected">
                                <option selected hidden >{{address.addressType}}</option>
                                  <option>POSTAL-ADDR</option>
                                  <option>HOME-ADDR</option>
                              </select>
                          </div><br>
                        </div>
                      </div>
                      <div v-if="isAddrUpdated === true" class="uk-alert-success" uk-alert>
                        <a class="uk-alert-close" @click="isAddrUpdated = false"uk-close></a>
                        <p>Address Updated.</p>
                      </div>
                    
                    </form>
                     <button v-on:click=" updateAddress($refs.addressTypeSelected[index].value, $refs.addressID[index].value)" class=" uk-button uk-button-danger uk-button-small uk-float-right">Update</button>
                  </div>
              </li>
            </ul>
          </div>
      </div>
        <ul uk-accordion>
          <li>
              <a class="uk-accordion-title" href="#"><span uk-icon="plus-circle" style="color: #4FD89C"></span> add address</a>
              <div class="uk-accordion-content">
                <form class="uk-child-width-1-3">
                  <div>
                    <label>Line 1</label>
                    <div>
                      <input v-model="addLine1" type="text" class="uk-input" name="">
                      <validate v-if="addLine1 == ''" :message= "message"></validate>
                    </div>
                  </div>
                  
                  <div>
                    <label>Line 2</label>
                    <div>
                      <input v-model="addLine2" type="text" class="uk-input" name="">
                      <validate v-if="addLine2 == ''" :message= "message"></validate>
                    </div>
                  </div>
                  
                  <div>
                    <label>Line 3</label>
                    <div>
                      <input v-model="addLine3" type="text" class="uk-input" name="">
                      <validate v-if="addLine3 == ''" :message= "message"></validate>
                    </div>
                  </div>
                  
                  <div>
                    <label>Line 4</label>
                    <div>
                      <input v-model="addLine4" type="text" class="uk-input" name="">
                      <validate v-if="addLine4 == ''" :message= "message"></validate>
                    </div>
                  </div>
                  
                  <div>
                    <label>Postal Code</label>
                    <div>
                      <input v-model="addPostalCode" type="text" class="uk-input" name="">
                      <validate v-if="addPostalCode == ''" :message= "message"></validate>
                    </div>
                  </div>
                  
                  <div>
                    <label>Address Type</label>
                    <div class="uk-margin">
                      <select class="uk-select" v-model="addAddressTypeSelected">
                          <option>Postal</option>
                          <option>Home</option>
                      </select>
                    </div><br>
                  </div>
                  
                  <button v-on:click.prevent="addAddress" class=" uk-button uk-button-secondary uk-button-small">Add</button>
                  <div v-if="isAddrAdded == true" class="uk-alert-success" uk-alert>
                    <a class="uk-alert-close" uk-close></a>
                    <p>Telephone Added <span class="uk-icon" uk-icon="check"></span></p>
                </div>
                </form>
              </div>
              <hr>
          </li>
          <hr>
        </ul>
      <br>

    <h3>Telephones Numbers <hr></h3>
    <div class="uk-container uk-margin-small">
      <div  class="uk-margin-small Telephone uk-background-muted uk-padding-small" v-for="telephone, index in telephonesGetter">  
         <ul uk-accordion>
            <li>
                <a class="uk-accordion-title" href="#">Telephone {{index + 1}}</a>
                <div class="uk-accordion-content">
                  <form class="uk-child-width-1-3">
                    <div>
                      <label>Number</label>
                        <div>
                          <input :value="telephone.number" type="text" class="uk-input" name="" ref="number">
                          <validate v-if="personTelephone == ''" :message= "message"></validate>
                          <input hidden="" :value="telephone.id" type="text" class="uk-input" name="" ref="telephoneID">
                        </div>
                    </div>
                    
                    <div>
                      <label>Telephone Type</label>
                        <div class="uk-margin">
                          <select class="uk-select" ref="telephoneTypeSelected">
                            <option selected disabled hidden> {{telephone.telephoneType}}</option>
                            <option>CELL-NUMBER</option>
                            <option>WORK-NUMBER</option>
                            <option>HOME-NUMBER</option>
                          </select>
                      </div>
                    
                      </div>
                      
                      <div v-if="isTelUpdated === true" class="uk-alert-success" uk-alert>
                          <a class="uk-alert-close" @click="isTelUpdated = false" uk-close></a>
                          <p>Telephone Updated.</p>
                      </div>

                    <button v-on:click.prevent="updateTelephone($refs.telephoneTypeSelected[index].value, $refs.telephoneID[index].value)" class=" uk-button uk-button-danger uk-button-small uk-float-right">Update</button>
                  </form>
                </div>
              </li>
            </ul>
      </div>
    </div>

    <ul uk-accordion>
      <li>
          <a class="uk-accordion-title" href="#"><span uk-icon="plus-circle" style="color: #4FD89C" ></span> add number</a>
          <div class="uk-accordion-content">
             <div class="uk-margin-large Telephone">
              <h5>Telephone</h5>
              <form class="uk-child-width-1-3">
                <div>
                  <label>Number</label>
                  <div>
                    <input v-model="addTelephoneNumber" type="text" class="uk-input" name="">
                    <validate v-if="addTelephoneNumber == ''" :message= "message"></validate>
                  </div>
                </div>
                
                <div>
                  <label>Telephone Type</label>  
                    <div class="uk-margin">
                      <select class="uk-select" v-model="addTelephoneTypeSelected" >
                        <option disabled>Select Telephone</option>
                        <option>Cell Number</option>
                        <option>Work</option>
                        <option>Home</option>
                      </select>
                    </div><br>
                </div>
              
                    <div v-if="isTelAdded === true" class="uk-alert-success" uk-alert>
                        <a class="uk-alert-close" @click="isTelAdded = false" uk-close></a>
                        <p>Telephone Updated.</p>
                    </div>
                    <button v-on:click.prevent="addTelephone" class=" uk-button uk-button-primary uk-button-smal uk-margin-remove-top">Add</button>
                  </form>
                </div>
              </div>
          </li>
        </ul>

    
     <button class="uk-button uk-button-secondary uk-float-right uk-margin-large" v-on:click="isAddingPeron = true">Done</button>
    </div> <!--Telephone_address-->

    
  </div>
    </div>
  </section>
</template>
<script>

import axios from 'axios'
import inputValidator from '@/components/inputValidator'
import { mapGetters } from 'vuex'

export default {

  computed: {
    ...mapGetters([
          'telephonesGetter',
          'addressesGetter',
          'countryGetter',
          'viewedPersonGetter'
      ]),

      runGetter(){
        return console.log('Data: '+ this.viewedPersonGetter)
      }
  },

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
      line1:'',line2:'',line3:'',line4:'',postalCode:'',
      addressTypeSelected:'',addressType:'',

      //country
      code: '',
      name :'',

      hideInput:true,

        //person
      firstName :'' ,secondName : '',thirdName : '',surname : '',
      identifier : '',CountryId : '',isPassport:'',passport :  false,
      personID:'',addressID:'',telephoneID:'',

      isAddingPeron:true,
      operation:'',

      message:'',

      //adding
      addTelephoneType:'',
      addTelephoneNumber:'',
      addTelephoneTypeSelected:'',

      addAddressTypeSelected:'',
      addAddressType:'',

      isTelAdded: false,
      isAddrAdded: false,
      isPersonUpdated: false,
      isTelUpdated: false,
      isAddrUpdated: false,

      //address
      addLine1:'',addLine2:'',addLine3:'',addLine4:'',addPostalCode:'',addAddressTypeSelected:'',addAddressType:'',
      navigate: 'Update Contact Information'
    }
  },
  watch:{
    isPassport: function(){
      if (this.isPassport === 'Yes' ) {
        this.passport = true
      } else if (this.isPassport === 'No') {
        this.passport = false
      }
    },
    isAddingPeron: function(){
      if (this.isAddingPeron === true ) {
        this.operation = 'Contact Information'
      } else if (this.isAddingPeron === false) {
        this.operation = 'Back To Person Information'
      }
    },
    addTelephoneTypeSelected: function(){
      if (this.addTelephoneTypeSelected === 'Cell Number' ) {
        this.addTelephoneType = 1
      }else if (this.addTelephoneTypeSelected === 'Work') {
        this.addTelephoneType = 2
      }else if (this.addTelephoneTypeSelected === 'Home') {
        this.addTelephoneType = 3
      }
    },
    addAddressTypeSelected: function(){
      if (this.addAddressTypeSelected === 'Postal' ) {
        this.addAddressType = 1
      } else if (this.addAddressTypeSelected === 'Home') {
        this.addAddressType = 2
      }
    }
  },
  methods:{
    addTelephone(){
      
      if (this.addTelephoneType === '' || this.addTelephoneNumber === '') {
          this.message = 'required field*'
          this.danger = true
          this.isAdded = false
          this.isTelAdded = false

      }else{
      
      let vm = this
       fetch('/api/telephone', {
          method: 'post',
           
           body: JSON.stringify({ 
            fkTelephoneTypeId: vm.addTelephoneType, 
            number: vm.addTelephoneNumber 
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
                        fkPersonId : vm.$route.params.update,
                        fkTelephoneId : vm.telephoneID,
                        current : true
                })

                }).then(response =>{
                    vm.isAdded = true
                    vm.addTelephoneNumber = ''
                })

              })
          });

        this.message = ''
        this.danger = false
        this.isTelAdded = true
      }

      this.isAdded = false
    },
    updateTelephone(telephoneCode, telephoneId){

      this.personTelephone = this.$refs.number[0].value;

      if (telephoneCode === 'CELL-NUMBER') {
        this.telephoneType = 1
      }
      else if (telephoneCode === 'WORK-NUMBER') {
        this.telephoneType = 2
      }else if (telephoneCode === 'HOME-NUMBER') {
        this.telephoneType = 3
      }

      console.log(this.telephoneType)
        
        if (this.personTelephone === '') {
          this.message = 'required*'
          this.danger = true
          this.isTelUpdated = false
        }else{
            fetch('/api/telephone/'  + telephoneId, {
              method: 'PUT',
              body: JSON.stringify({ 
                   fkTelephoneTypeId: this.telephoneType, 
                   number: this.personTelephone 
                })
            }).then(response => {
                 this.telephoneType = ''
                 this.personTelephone = ''
          });

          this.message = ''
          this.danger = false
          this.isTelUpdated = true
      }
         
    },
    updateAddress(addressCode,addressId){

      this.line1 = this.$refs.line1[0].value;
      this.line2 = this.$refs.line2[0].value;
      this.line3 = this.$refs.line3[0].value;
      this.line4 = this.$refs.line4[0].value;
      this.postalCode = this.$refs.postalCode[0].value;
      this.addressID = this.$refs.addressID[0].value;
      


      if (addressCode === 'POSTAL-ADDR') {
        this.addressType = 1
      }
      else if (addressCode === 'HOME-ADDR') {
        this.addressType = 2
      }

      console.log(this.addressType)

      
      if (this.line1 === '' || this.line2 === '' || this.line3 === '' || this.line4 === '' || this.postalCode === '' || this.addressType === '') {
        this.message = 'required*'
        this.danger = true
        this.isAddrUpdated = false
      }else{
        let vm = this
           fetch('/api/address/' + addressId, {
                method: 'PUT',
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
      });

        this.message = ''
        this.danger = false
        this.isAddrUpdated = true

      }
         
    },
      update(){

        this.firstName = this.$refs.firstName[0].value;
        this.secondName = this.$refs.secondName[0].value;
        this.thirdName = this.$refs.thirdName[0].value;
        this.surname = this.$refs.surname[0].value;
        this.identifier = this.$refs.identifier[0].value;
        this.passport = this.$refs.isPassport[0].value;
          
        this.code = this.$refs.code[0].value.toString();
        this.name = this.$refs.name[0].value.toString();
        this.personID = this.$route.params.update;
        this.CountryId = this.$refs.id[0].value;
        //console.log(this.CountryId)
        
        if(this.code === '' || this.name === '' || this.firstName === ''|| this.secondName === ''|| this.thirdName === ''|| this.surname === '' || this.identifier === ''){
          this.message = 'required field*'
          this.danger = true
          this.isPersonUpdated = false
        }else{

          let vm = this
          axios.get('/api/country/' + this.name)       
          .then(function(countrySearch) {
            
            if (countrySearch.data.length == 0){
              fetch('/api/country', {
                  method: 'post',
                  body: JSON.stringify({ 
                    code : vm.code,
                    name: vm.name,
                  }
            )}).then(response => {

                fetch('/api/countries')
                  .then(function(response) {
                    return response.json();
                   
                  })
                  .then(function(myJson) {
                    vm.CountryId = myJson[myJson.length -1].id
                    
                      fetch('/api/person/' + vm.personID, {
                        method: 'put',
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
                      vm.isAddingPeron = false;
                      vm.navigate = 'Update Person Information'
                      vm.message = ''
                      vm.danger = false
                    });
                 });
              });

            }else{
              vm.CountryId = countrySearch.data[countrySearch.data.length -1].id
              console.log(vm.CountryId) 

                //update Person
              fetch('/api/person/' + vm.personID, {
                    method: 'put',
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
                    console.log(response)
                  });
                 
                 vm.isAddingPeron = false;
                 vm.navigate = 'Update Person Information'
                 vm.message = ''
                 vm.danger = false
            }
          })
       }
    },
    check(){
    },

    getUser(param){
      this.$router.push(`view/${this.personID}`)  

    },
    navigating(){
         this.isAddingPeron = !this.isAddingPeron;

         if (this.isAddingPeron === false) {
            this.navigate = 'Back to Person Information'
         }else{
          this.navigate = 'Update Contact Information'
         }
          
          this.danger=false 
          this.message=''
    
    },

    addAddress(){

      if (this.addLine1 === '' || this.addLine2 === '' || this.addLine3 === '' || this.addLine4 === '' || this.addPostalCode === '' || this.addAddressType === '') {
          this.message = 'required*'
          this.danger = true
          this.isAddrAdded = false
      }else{

        let vm = this
           fetch('/api/address', {
           method: 'post',
           
          body: JSON.stringify({ 
              line1 : this.addLine1,
              line2: this.addLine2,
              line3 : this.addLine3,
              line4 : this.addLine4,
              postalCode : this.addPostalCode,
              fkAddressTypeId : this.addAddressType
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
                  fkPersonId : vm.$route.params.update,
                  fkAddressId : vm.addressID,
                  current : true
              })
            }).then(response =>{
                vm.isAddrAdded = true

                //clear inputs
                vm.addLine1
                vm.addLine2
                vm.addLine3
                vm.addLine4
                vm.addPostalCode
            })
          })
      });
        this.message = ''
        this.danger = false
        this.isAddrAdded = true
      }
  }

  },

  //for page refresh
  async asyncData ({ params, store, app}) {
          return await app.$axios.get(`/api/getAddresses/${params.update}`)
              .then((response) => {
                store.commit('addAddresses', response.data)
              return app.$axios.get(`/api/getTelephones/${params.update}`)
                .then((response) => {
                   store.commit('addTelephones', response.data)

                    return app.$axios.get(`/api/personInformation/${params.update}`)
                       .then((response) => {
                          store.commit('AddViewedPerson', response.data)

                        return app.$axios.get(`/api/personCountry/${params.update}`)
                        .then((response) => {
                           store.commit('addCountry', response.data)
                         })
                    })
            })

  })
  }
}

 // this.$router.push(`/update/${this.$route.params.view}`)
</script>

<style>

.bg{
  background-color: #617852;
}

h3{
  font-size: 19px;
  color: #4A1395;
}
label{
  font-family: Berlin Sans FB;
  color: #005114;
}





</style>
