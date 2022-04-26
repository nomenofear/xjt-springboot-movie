import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

const Login = () => import('@/views/Login.vue');
const Register = () => import('@/views/Register.vue');

const Home = () => import('@/views/Home.vue');
const Index = () => import('@/views/index/Index.vue');

const Films = () => import('@/views/film/Films.vue');
const FilmDetail = () => import('@/views/film/FilmDetail.vue');

const Cinemas = () => import('@/views/cinema/Cinemas.vue');
const Board = () => import('@/views/board/Board.vue');
const News = () => import('@/views/news/News.vue');


const routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: { title: '登录页' }
  },
  {
    path: '/register',
    name: 'Register',
    component: Register,
    meta: { title: '注册页' }
  },
  {
    path: '/',
    name: 'Home',
    component: Home,
    redirect: "/index",
    children: [
      {
        path: '/index',
        name: '首页',
        component: Index,
        meta: { title: '首页' }
      },
      {
        path: '/films',
        name: '电影',
        component: Films,
        meta: { title: '电影' }
      },
      {
        path: '/cinemas/:movieId',
        name: '购票',
        component: import('@/views/index/comps/MovieBuyTicket.vue'),
        meta: { title: '上映电影购票' }
      },
      {
        path: '/film/:id',
        name: '电影详情页',
        component: FilmDetail,
        meta: { title: '电影详情' }
      },
      {
        path: '/cinemas',
        name: '影院',
        component: Cinemas,
        meta: { title: '影院' }
      },
      {
        path: '/board',
        name: '榜单',
        component: Board,
        meta: { title: '榜单' }
      },
      {
        path: '/news',
        name: '热点',
        component: News,
        meta: { title: '热点' }
      },
    ]
  },
];

export default new VueRouter({
  routes,
  mode: "history"
});
