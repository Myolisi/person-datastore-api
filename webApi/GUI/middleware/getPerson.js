import axios from 'axios'

export default function({params,store, app}){
    return app.$axios.get(`/api/getAddresses/${params.view}`)
		          .then((response) => {
		           store.commit('addAddresses', response.data)
					    return app.$axios.get(`/api/getTelephones/${params.view}`)
						    .then((response) => {
						       store.commit('addTelephones', response.data)

						        return app.$axios.get(`/api/personInformation/${params.view}`)
						           .then((response) => {
						            store.commit('AddViewedPerson', response.data)

						            return app.$axios.get(`/api/personCountry/${params.view}`)
							          .then((response) => {
							           store.commit('addCountry', response.data)
							           })
						        })
						})

	})

}

