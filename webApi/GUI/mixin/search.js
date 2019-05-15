
import axios from 'axios'
import { mapGetters } from 'vuex'
import searchPerson from '@/components/searchPerson'

export default {
  middleware: 'getPersons',

  computed: {
    ...mapGetters([
          'personGetter'
      ])
  },


  components: {
    'searchPerson': searchPerson
  }, 
  data: function(){
    return{
      searchValue:'',
      telephones:[]
    }
  },
  methods:{
    submit(){
      if (this.searchValue !== '' ) {
        this.$router.push(`search/${this.searchValue}`)
      }
      
    }
  }
}