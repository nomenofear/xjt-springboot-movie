import router from './router.js'
import store from '@/store/store.js'
import {getToken,setToken,removeToken} from "@/utils/auth.js"

import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css'

NProgress.configure({ showSpinner: false })

const whiteList = ['/login'];        // no redirect whitelist

router.beforeEach((to, from, next) => {
  console.log(to);
  console.log(store.state);
  if (to.meta.title) {
    document.title = to.meta.title + ' - ' + "xjt"
  }
  NProgress.start();
  if (getToken()) {
    // 已登录且要跳转的页面是登录页
    if (to.path === '/login') {
      next({ path: '/' })
      NProgress.done()
    }else{
      next();
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {      // 在免登录白名单，直接进入
      next()
    } else {
      next(`/login?redirect=${to.fullPath}`)      // 否则全部重定向到登录页
      NProgress.done()
    }
  }
});

router.afterEach(() => {
  NProgress.done()    // finish progress bar
})
