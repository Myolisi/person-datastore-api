const pkg = require('./package')

module.exports = {
  mode: 'universal',

  /*
  ** Headers of the page
  */
  head: {
    title: pkg.name,
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: pkg.description }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ],
    script: [
      { src:'https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.5/lodash.min.js' }
    ],
  },

  /*
  ** Customize the progress-bar color
  */
  loading: { color: '#07BAF3' },

  /*
  ** Global CSS
  */
  css: [
  'uikit/dist/css/uikit.css',
  'assets/main.css'
  ],

  /*
  ** Plugins to load before mounting the App
  */
  plugins: [
    { src: '~/plugins/uikit.js', ssr: false },
    { src: '~/plugins/lodash.js', ssr: false }
  ],

  router: {
    
  },
  /*
  ** Nuxt.js modules
  */
  modules: [
    // Doc: https://github.com/nuxt-community/axios-module#usage
    '@nuxtjs/axios',
	  '@nuxtjs/proxy'
  ],

  /*
  ** Axios module configuration
  */
  axios: {

    // See https://github.com/nuxt-community/axios-module#options
  },

  /*
  ** Build configuration
  */
  build: {
    /*
    ** You can extend webpack config here
    */
    vendor: ['axios'],
    extend(config, ctx) {
      
    }
  },
  proxy: {
        '/api': {
            target: 'http://localhost:4567',
            changeOrigin: true,
            pathRewrite: {
                '^/api' : '/'
        }
    } 
  }

}
