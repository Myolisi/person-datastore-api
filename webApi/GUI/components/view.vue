<template>
  <section>
  	<div class="uk-container">
        
        <div v-show="person.length > 0">
          <div class=" uk-margin-small uk-card uk-padding">
              <button v-on:click="editUser" class="uk-button uk-button-primary uk-float-right uk-margin-medium-top uk-margin-xlarge-right">Edit</button>
              <table class="uk-table uk-width-1-2 ">
                <caption><h4>Personal Information</h4></caption>
                <thead>
                    <tr>
                        <th></th>
                    </tr>
                </thead>

                <tbody v-for="personal in person" >
                    <tr>
                        <td ><h5>First Name</h5></td>
                        <td>{{personal.firstName}}</td> 
                    </tr> 

                    <tr> 
                        <td><h5>Second Name</h5></td>
                        <td>{{personal.secondName}}</td>
                    </tr>

                    <tr>
                        <td><h5>Third Name</h5></td>
                        <td>{{personal.thirdName}}</td>
                    </tr>  

                    <tr>
                        <td><h5>Surname</h5></td>
                        <td>{{personal.surname}}</td></td>
                    </tr>

                    <tr>
                        <td><h5>Indentity</h5></td>
                        <td>{{personal.identifier}}</td></td>
                    </tr>

                    <tr v-for="country in country">
                        <td><h5>Nationality</h5></td>
                        <td>{{country.name}}</td></td>
                    </tr>
                </tbody>
               </table>
              </div>

              
              <div class="uk-margin-small uk-card uk-padding">
                <table class="uk-table uk-width-1-2 ">
                <caption><h4>Contact Details</h4></caption>
                <thead>
                    <tr>
                        <th></th>
                    </tr>
                </thead>
                <template v-if="telephones.length > 0">
                <tbody v-for="telephone in telephones" >
                    <tr>
                        <td><h5>{{telephone.telephoneType}}</h5></td>
                        <td>{{telephone.number}}</td>
                    </tr> 
                </tbody>
                </template>
                <template v-else>
                  <div class="uk-text-center">
                    <p>Contact list empty</p>
                  </div>
                </template>
               </table>
              </div>
            

              
              <div class=" uk-margin-small uk-card  uk-padding">
                <table class="uk-table uk-width-1-2">
                <caption><h4>Addresses</h4></caption>
                <thead>
                    <tr>
                        <th></th>
                    </tr>
                </thead>
                <template v-if="addresses.length > 0">
                <tbody v-for="address in addresses" >
                    <tr>
                        <td><h5>{{address.addressType}}</h5></td>
                       <td>
                          {{address.line1}}
                          <br>{{address.line2}}
                          <br>{{address.line3}}
                          <br>{{address.line4}}
                          <br>{{address.postalCode}}
                        </td> 
                    </tr> 
                </tbody>
                 </template>
                <template v-else>
                  <div class="uk-text-center">
                    <p>Addresses list empty</p>
                  </div>
                </template>
               </table>
              </div>
        </div>

        <div v-show="person.length == 0" class="uk-position-center uk-width-1-3">
          <div class="uk-placeholder uk-text-center"><h4>User not found </h4></div>
        </div>

    </div>
  </section>
</template>
<script>


export default {
  props:['person', 'telephones', 'addresses', 'country' ],
   methods:{
    editUser(){
      this.$router.push(`/update/${this.$route.params.view}`)
    }
  }
}


</script>

<style>

.bg{
  background-color:#fff;
}

h5{
  font-family: Berlin Sans FB;
  font-size: 17px;
}
caption{
  background-color: #F3F9F6;
  padding:10px;
}

</style>
