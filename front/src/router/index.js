import Vue from 'vue'
import Router from 'vue-router'
import BigSearch from '@/components/search/BigSearch'
import SearchResult from '@/components/search/SearchResult'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'BigSearch',
      component: BigSearch
    },
    {
      path: '/result/:keyword',
      name: 'SearchResult',
      component: SearchResult,
      props: true
    }
  ]
})
