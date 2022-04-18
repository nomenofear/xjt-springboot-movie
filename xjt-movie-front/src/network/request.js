import axios from 'axios'

export const request = (config) => {
  const instance = axios.create({
    baseURL: '/api',
    timeout: 8000,
    withCredentials: true,       //可以跨域
  });

  instance.interceptors.request.use(config => {
    let token = window.localStorage.getItem('token');
    if (!(token == "" || token == null)) {
      config.headers.common['token'] = token;
    }

    return config
  }, err => {
    return err
  });

  instance.interceptors.response.use(response => {
    return response.data
  }, err => {
    console.log('来到了response拦截failure中=====>');
    console.log(err);
    if (err && err.response) {
      switch (err.response.status) {
        case 400:
          err.message = '请求错误';
          break;
        case 401:
          err.message = '未授权的访问';
          break
      }
    }
    return err
  });

  return instance(config);
};

//封装请求
let base = '';          //避免前缀要一个一个去改，太麻烦

export const $getRequest = (url, params) => {
  return request({
    method: 'get',
    url: `${base}${url}`,
    data: params
  })
};

export const $postRequest = (url, params) => {
  return request({
    method: 'post',
    url: `${base}${url}`,
    data: params  //这是用json来传递的，所以不用加transformRequest转换了
  })
};

