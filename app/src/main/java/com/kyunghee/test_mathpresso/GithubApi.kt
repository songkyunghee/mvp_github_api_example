package com.kyunghee.test_mathpresso

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.logging.Filter

interface GithubApi {
    @GET("search/users")
    fun getUserList(@Query("q") q: String): Observable<List<GithubResponse>>
}