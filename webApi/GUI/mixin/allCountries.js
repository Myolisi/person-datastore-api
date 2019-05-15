
import axios from 'axios'

export default {
  data: function(){
    return{
      
    }
  }, 
  beforeMount(){
      axios.get(`https://restcountries.eu/rest/v2/all`)
      .then((res) => {
        this.countryList = res.data
        this.$store.commit('fillCountryList', res.data)
      })
  }
}