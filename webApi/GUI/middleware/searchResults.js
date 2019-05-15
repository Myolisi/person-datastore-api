import axios from 'axios'

export default function({params,store, app}){
	let id = '';
    return app.$axios.get(`http://localhost:4567/person/${params.search}`)
    .then((response) => {
      store.commit('fillSearch', response.data)
      //get the id of the person
      response.data.forEach(function(item) {
        id = item.id;
      })
	     return app.$axios.get('http://localhost:4567/getTelephones/' + id)
		    .then((response) => {
		       store.commit('addTelephones', response.data)

		       return app.$axios.get('http://localhost:4567/getAddresses/' + id)
		          .then((response) => {
		           store.commit('addAddresses', response.data)
		        })
		 })
		    
    }).catch(error => {
		console.log(error)
		
	});
}