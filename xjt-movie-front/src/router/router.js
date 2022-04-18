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
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/',
        name: 'Home',
        component: Home,
        redirect:"/index",
        children: [
            {
                path: '/index',
                name: '首页',
                component: Index
            },
            {
                path: '/films',
                name: '电影',
                component: Films
            },
            {
                path: '/film/:id',
                name: '电影详情页',
                component: FilmDetail
            },
            {
                path: '/cinemas',
                name: '影院',
                component: Cinemas
            },
            {
                path: '/board',
                name: '榜单',
                component: Board
            },
            {
                path: '/news',
                name: '热点',
                component: News
            },
        ]
    },
];

export default new VueRouter({
    routes,
    mode: "history"
});
