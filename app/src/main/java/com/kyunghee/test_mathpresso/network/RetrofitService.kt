package com.kyunghee.test_mathpresso.network

import com.kyunghee.test_mathpresso.model.GithubResponse
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
        private var apiClient: RetrofitService?= null

       val instance : RetrofitService
           get() {
            if(apiClient == null) {
                apiClient =
                    RetrofitService()
            }
            return apiClient as RetrofitService
        }
    }

    fun getUserList(login : String) : Observable<GithubResponse> {
        return service.getList(login)
    }

}