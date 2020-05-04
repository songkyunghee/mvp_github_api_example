package com.kyunghee.test_mathpresso.model

import com.google.gson.annotations.SerializedName

data class GithubResponse (
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatar_url: String
)