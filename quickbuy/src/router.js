import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/search/:searchvar',
      name: 'search',
      component: () => import('@/views/Search.vue')
    },
    {
      path: '/search/',
      name: 'searchNovalue',
      component: () => import('@/views/Search.vue')
    },
    {
      path: '/products/:prodpid',
      name: 'products',
      component: () => import('@/views/Products.vue')
    },
    {
      path: '/cart',
      name: 'cart',
      component: () => import('@/views/Cart.vue')
    },
    {
      path: '/cart/order',
      name: 'order',
      component: () => import('@/views/Order.vue')
    },
    {
      path: '/signup',
      name: 'signup',
      component: () => import('@/views/Signup.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/Login.vue')
    }
  ]
})
