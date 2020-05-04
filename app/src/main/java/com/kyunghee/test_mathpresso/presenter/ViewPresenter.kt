package com.kyunghee.test_mathpresso.presenter

import com.kyunghee.test_mathpresso.model.GithubResponse

interface ViewPresenter {

    interface ModelPresenter {
        fun loadItem(login: String)
        fun onStop()
    }

    interface View{
        fun updateView(items: GithubResponse)
    }
}