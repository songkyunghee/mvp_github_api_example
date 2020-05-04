package com.kyunghee.test_mathpresso

import com.google.gson.annotations.SerializedName

data class GithubResponse (
    @SerializedName("login") val login: String,
   // @SerializedName("id") val id: String,
    @SerializedName("avatar_url") val avatar_url: String
)