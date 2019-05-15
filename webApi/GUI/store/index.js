import Vuex from 'vuex'

const store = () => {
  return new Vuex.Store({
    state: {
      persons: [],
      searchResult: [],
      id:'',
      telephones:[],
      addresses:[],
      viewedPerson:[],
      country:[],
      noResults: false,
      isAddingPerson: false,
      countryList: []

    },

    //Mutation
    mutations: {
      add (state, list) {
        state.persons = list
      },
      fillSearch (state, list ){
        state.searchResult = list
      },
      addTelephones (state, list) {
        state.telephones = list
      },
      addAddresses (state, list) {
        state.addresses = list
      },
      AddViewedPerson (state, list){
        state.viewedPerson = list
      },
       addCountry (state, list){
        state.country = list
      },
      fillCountryList(state, payload){
        state.countryList = payload
      }
    },


    //Getter
    getters:{
      searchResultsGetter: state =>{
        return state.searchResult
      },
      telephonesGetter: state =>{
        return state.telephones
      },
      addressesGetter: state =>{
        return state.addresses
      },
      countryGetter: state =>{
        return state.country
      },
      viewedPersonGetter: state =>{
        return state.viewedPerson
      },
      personGetter: state =>{
        return state.persons
      },
      getCountryList: state =>{
        return state.countryList
      }
    },


    //Action
    actions: {
      add (context) {
        context.commit('AddViewedPerson')
      }
    }
    })
}

export default store