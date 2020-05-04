package com.kyunghee.test_mathpresso

interface ViewPresenter {

    interface ModelPresenter {
        fun loadItem(login: String)
        fun onStop()
    }

    interface View{
        fun updateView(items: GithubResponse)
    }
}