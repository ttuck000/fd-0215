
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import OrderManagementManager from "./components/listers/OrderManagementCards"
import OrderManagementDetail from "./components/listers/OrderManagementDetail"

import ReviewManager from "./components/listers/ReviewCards"
import ReviewDetail from "./components/listers/ReviewDetail"

import ReviewSearchView from "./components/ReviewSearchView"
import ReviewSearchViewDetail from "./components/ReviewSearchViewDetail"
import KakaotalkView from "./components/KakaotalkView"
import KakaotalkViewDetail from "./components/KakaotalkViewDetail"
import OrderSearchView from "./components/OrderSearchView"
import OrderSearchViewDetail from "./components/OrderSearchViewDetail"
import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/orderManagements',
                name: 'OrderManagementManager',
                component: OrderManagementManager
            },
            {
                path: '/orderManagements/:id',
                name: 'OrderManagementDetail',
                component: OrderManagementDetail
            },

            {
                path: '/reviews',
                name: 'ReviewManager',
                component: ReviewManager
            },
            {
                path: '/reviews/:id',
                name: 'ReviewDetail',
                component: ReviewDetail
            },

            {
                path: '/reviewSearches',
                name: 'ReviewSearchView',
                component: ReviewSearchView
            },
            {
                path: '/reviewSearches/:id',
                name: 'ReviewSearchViewDetail',
                component: ReviewSearchViewDetail
            },
            {
                path: '/kakaotalks',
                name: 'KakaotalkView',
                component: KakaotalkView
            },
            {
                path: '/kakaotalks/:id',
                name: 'KakaotalkViewDetail',
                component: KakaotalkViewDetail
            },
            {
                path: '/orderSearches',
                name: 'OrderSearchView',
                component: OrderSearchView
            },
            {
                path: '/orderSearches/:id',
                name: 'OrderSearchViewDetail',
                component: OrderSearchViewDetail
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },



    ]
})
