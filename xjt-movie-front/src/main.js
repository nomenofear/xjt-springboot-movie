import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store/store'

Vue.config.productionTip = false;

import * as echarts from "echarts"
Vue.prototype.$echarts = echarts;

/*使用element-ui*/
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

/*对象转URL query请求格式-组件*/
import qs from 'qs'
Vue.prototype.$qs = qs;

/*使用less*/
import less from "less"
Vue.use(less);

/*背景例子特效-组件*/
import VueParticles from 'vue-particles'
Vue.use(VueParticles);

/*hover.css样式*/
import hover from "hover.css"
Vue.use(hover);

import {$getRequest, $postRequest} from "@/network/request.js"

Vue.prototype.$getRequest = $getRequest;
Vue.prototype.$postRequest = $postRequest;

/*全局使用mixin*/
import {myMixin} from "@/mixins/mixin.js"
Vue.mixin(myMixin);

/*定义常量*/
import global from "@/utils/global.js"
Vue.prototype.$const = global;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
