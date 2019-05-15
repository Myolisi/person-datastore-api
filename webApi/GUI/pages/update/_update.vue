<template>
  <section>
    <div class="uk-container">
      <div v-show="isPersonUpdated === true" class="uk-alert-success uk-flex uk-flex-bottom uk-width-1-4" uk-alert>
            <a class="uk-alert-close" uk-close></a>
            <p>Person Updated.</p>
          </div>
     <h4>User Id: <span class="uk-label uk-label-success">{{$route.params.update}}</span></h4>
      <span @click.prevent="navigating" class="navigate uk-float-right uk-button uk-margin-remove-top"><h4 style="color: blue">{{navigate}}</h4></span>

      <div v-show="isAddingPeron === true" class="personal_information">
        <h3>Personal Information <hr class="uk-divider-icon"></h3>
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
                <div>
                  <select  class="uk-select" ref="name"> 
                    <option selected >{{personCountry.name}}</option>
                    <option v-for="items in getCountryList">{{items.name}}</option>
                  </select> 
                </div>
                <input hidden="" disabled="" :value="personCountry.id" type="text" class="uk-input" name="" ref="id">
            </div>
            <button v-on:click.prevent="update"  class=" uk-margin-top uk-button uk-button-primary uk-button-small">Update</button> 
          </form>
        </div>
    </div><!--Personal Information-->
  
  <div v-show="isAddingPeron === false" class="telephone_Address">
    <h3>Address <hr class="uk-divider-icon"></h3>
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
                      <div v-show="isAddrUpdated === true" class="uk-alert-success" uk-alert>
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
                
                  <div v-show="isAddrAdded == true" class="uk-alert-success" uk-alert>
                    <a class="uk-alert-close" uk-close></a>
                    <p>Address Added <span class="uk-icon" uk-icon="check"></span></p>
                </div>
                </form>
                <button v-on:click.prevent="addAddress" class=" uk-button uk-button-primary uk-button-small">Add</button>
              </div>
          </li>
        </ul>
      <br>

    <h3>Telephones Numbers <hr class="uk-divider-icon"></h3>
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
                      
                      <div v-show="isTelUpdated === true" class="uk-alert-success" uk-alert>
                          <a class="uk-alert-close" @click="isTelUpdated = false" uk-close></a>
                          <p>Telephone Updated.</p>
                      </div>
                  </form>
                   <button v-on:click.prevent="updateTelephone($refs.telephoneTypeSelected[index].value, $refs.telephoneID[index].value)" class=" uk-button uk-button-danger uk-button-small uk-float-right">Update</button>
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
                    <div v-show="isTelAdded === true" class="uk-alert-success" uk-alert>
                        <a class="uk-alert-close" @click="isTelAdded = false" uk-close></a>
                        <p>Telephone Updated.</p>
                    </div>
                    
                  </form>
                  <button v-on:click.prevent="addTelephone" class=" uk-button uk-button-primary uk-button-small uk-margin-remove-top">Add</button>
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

	import update from '@/mixin/update'
	
	export default{
		
		mixins:[update],
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
	},
	addTelephone(){
		this.fkPersonId = vm.$route.params.update
  },

  addAddress(){
    this.addAddress()
  }
	
}

</script> 