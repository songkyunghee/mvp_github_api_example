package com.kyunghee.test_mathpresso

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.logging.Filter

interface GithubApi {
    @GET("users/{user}")
    fun getList(@Path("user") user: String): Observable<GithubResponse>
}