import Vue from 'vue'
import Vuetify from 'vuetify'
import '@babel/polyfill'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import store from 'store/store'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'
/*
    главная страничка которая подгружает остальные компоненты
 */

if (frontendData.profile) {
    connect()
}

Vue.use(Vuetify)

const opts = {}

export default new Vuetify(opts)

new Vue({
    el:'#app',
    store, // store: store
    router, // router: router
    vuetify: new Vuetify(),
    render: a => a(App)
})


