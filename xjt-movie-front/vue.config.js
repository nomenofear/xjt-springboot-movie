module.exports = {
  devServer: {
    port: 8882,
    open: true,
    proxy: {    //解决跨域问题
      '/api': {
        target: 'http://localhost:8880/',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
};
