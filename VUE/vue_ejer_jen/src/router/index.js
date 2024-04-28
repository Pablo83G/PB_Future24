import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Ejercicio1 from '../views/Ejercicio1.vue'
import Ejercicio2 from '../views/Ejercicio2.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/uno',
    name: 'uno',
    component: Ejercicio1
  },
  {
    path: '/dos',
    name: 'dos',
    component: Ejercicio2
  }
]

const router = new VueRouter({
  routes
})

export default router
