import Vue from 'vue'
import Vuex, { Store } from 'vuex'

import state from './state'
import * as getters from './getters'
import actions from './actions'
import mutations from './mutations'

import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const store = new Store({
  state,
  getters,
  actions,
  mutations,
  strict: process.env.NODE_ENV !== 'production',
	plugins: [createPersistedState({
		storage: window.sessionStorage
	})],
})

if (module.hot) {
  module.hot.accept([
    './getters',
    './actions',
    './mutations'
  ], async () => {
    store.hotUpdate({
      getters: await import('./getters'),
      actions: await import('./actions'),
      mutations: await import('./mutations')
    })
  })
}

export default store
