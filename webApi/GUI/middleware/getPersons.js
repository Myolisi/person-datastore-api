import axios from 'axios'

export default  function({store}){
    return axios.get('http://localhost:4567/persons').then((response) => {
      store.commit('add', response.data)
    })
}