import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import {getToken,setToken,removeToken} from "@/utils/auth.js"

export default new Vuex.Store({
  state: {
    login_user: getToken() || {},    //登录的用户信息
  },
  mutations: {
    updateLoginUser(state, payload) {
      setToken(payload);
      state.login_user = payload;
    },
    removeLoginUser(state){
      removeToken();
      state.login_user = {};
    },
  },
  actions: {
  },
  modules: {
  }
})
