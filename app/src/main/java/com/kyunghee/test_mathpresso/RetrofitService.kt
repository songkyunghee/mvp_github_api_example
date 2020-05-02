package com.kyunghee.test_mathpresso

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    private val service : GithubApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Observable 객체로 반환
            .build()

        service = retrofit.create(GithubApi::class.java)
    }

    companion object{
        private const val BASE_URL="http://api.github.com"
    }

    fun getUsers(login : String) : Observable<List<GithubResponse>> {
        return service.getUserList(login)
    }

}