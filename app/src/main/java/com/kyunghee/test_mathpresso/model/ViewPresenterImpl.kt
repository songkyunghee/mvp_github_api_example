package com.kyunghee.test_mathpresso.model


import android.util.Log
import androidx.annotation.NonNull
import com.kyunghee.test_mathpresso.presenter.ViewPresenter
import com.kyunghee.test_mathpresso.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class ViewPresenterImpl :
    ViewPresenter.ModelPresenter {


    var view: ViewPresenter.View? = null

    @NonNull
    var disposable: Disposable? = null

    constructor(view: ViewPresenter.View?){
        this.view=view
    }

    override fun loadItem(login: String) {

         disposable = RetrofitService.instance.getUserList(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({items -> view!!.updateView(items) },{throwable->Log.e("ERROR","error")})

    }

    override fun onStop() {
        if(disposable != null) {
            disposable!!.dispose()
        }
    }


}