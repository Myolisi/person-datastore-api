import axios from 'axios'
import inputValidator from '@/components/inputValidator'
import { mapGetters } from 'vuex'
import allCountries from '@/mixin/allCountries'

export default {
  mixins:[allCountries],
  computed: {
    ...mapGetters([
          'telephonesGetter',
          'addressesGetter',
          'countryGetter',
          'viewedPersonGetter',
          'getCountryList'

      ])
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
    //   name:function(){
    //     if (this.name !== '') {
    //       this.getCountry()
    //       let country = this.countryGetter[0].name
    //         this.countryInformation = this.getCountryList.filter(function(items){
    //           return items.name === country
    //         })
    //         //get code for the returned country
    //         this.code = this.countryInformation[0].alpha3Code
    //           console.log(this.code)
    //     }
      
    // },

      watch(firstName){
          immediate: true
          console.log('bang')
      },
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
                    vm.isTelAdded = true
                    setTimeout(()=>{
                      vm.isTelAdded = false
                    }, 3000)
                    vm.addTelephoneNumber = ''
                })

              })
          });

        this.message = ''
        this.danger = false
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

        this.name = this.$refs.name[0].value.toString();


        let country = this.name
            this.countryInformation = this.getCountryList.filter(function(items){
              return items.name === country
        })
            //get code for the returned country
        this.code = this.countryInformation[0].alpha3Code

        this.firstName = this.$refs.firstName[0].value;
        this.secondName = this.$refs.secondName[0].value;
        this.thirdName = this.$refs.thirdName[0].value;
        this.surname = this.$refs.surname[0].value;
        this.passport = this.$refs.isPassport[0].value;
        // this.code = this.$refs.code[0].value.toString();
        
        this.personID = this.$route.params.update;
        this.CountryId = this.$refs.id[0].value;
        //console.log(this.CountryId)
        
        if(this.code === '' || this.name === '' || this.firstName === ''|| this.secondName === ''|| this.thirdName === ''|| this.surname === ''){
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
                            fkCountryId : vm.CountryId,
                            passport : vm.passport
                       })
                    }).then(response => {
                      
                      setTimeout(() =>{
                        vm.isAddingPeron = false;
                        }, 500)

                      vm.navigate = 'Update Person Information'
                      vm.message = ''
                      vm.danger = false
                    });
                 });
              });

            }else{
              vm.CountryId = countrySearch.data[countrySearch.data.length -1].id
              console.log(vm.personID) 

                //update Person
              fetch('/api/person/' + vm.personID, {
                    method: 'put',
                    body: JSON.stringify({ 
                      firstName : vm.firstName ,
                      secondName : vm.secondName ,
                      thirdName : vm.thirdName,
                      surname : vm.surname,
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
           
          body: { 
              line1 : this.addLine1,
              line2: this.addLine2,
              line3 : this.addLine3,
              line4 : this.addLine4,
              postalCode : this.addPostalCode,
              fkAddressTypeId : this.addAddressType
        }

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
                setTimeout(()=>{
                  vm.isAddrAdded = false
                }, 3000)

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
      }
  }

  },

  //for page refresh
  // async asyncData ({ params, store, app}) {
  //         return await app.$axios.get(`/api/getAddresses/${params.update}`)
  //             .then((response) => {
  //               store.commit('addAddresses', response.data)
  //             return app.$axios.get(`/api/getTelephones/${params.update}`)
  //               .then((response) => {
  //                  store.commit('addTelephones', response.data)

  //                   return app.$axios.get(`/api/personInformation/${params.update}`)
  //                      .then((response) => {
  //                         store.commit('AddViewedPerson', response.data)

  //                       return app.$axios.get(`/api/personCountry/${params.update}`)
  //                       .then((response) => {
  //                          store.commit('addCountry', response.data)
  //                        })
  //                   })
  //           })

  // })
  // }
}

 // this.$router.push(`/update/${this.$route.params.view}`)




