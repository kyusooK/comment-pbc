
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CommentCommentPbcManager from "./components/listers/CommentCommentPbcCards"
import CommentCommentPbcDetail from "./components/listers/CommentCommentPbcDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/comments/commentPbcs',
                name: 'CommentCommentPbcManager',
                component: CommentCommentPbcManager
            },
            {
                path: '/comments/commentPbcs/:id',
                name: 'CommentCommentPbcDetail',
                component: CommentCommentPbcDetail
            },



    ]
})
