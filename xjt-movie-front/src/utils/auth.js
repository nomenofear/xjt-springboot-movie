export function getToken() {
  return JSON.parse(window.sessionStorage.getItem("xjt_movie"));
}

export function setToken(token, rememberMe) {
  // val必须是字符串
  // window.sessionStorage.setItem(key,val);
  // window.sessionStorage.setItem("LoginUser",JSON.stringify(payload));

  window.sessionStorage.setItem("xjt_movie",JSON.stringify(token));
}

export function removeToken() {
  return window.sessionStorage.removeItem("xjt_movie");
}
