package com.kyunghee.test_mathpresso.network

import com.kyunghee.test_mathpresso.model.GithubResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {
    @GET("users/{user}")
    fun getList(@Path("user") user: String): Observable<GithubResponse>
}