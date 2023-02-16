package com.example.retrofit_practice.model

import com.google.gson.annotations.SerializedName

class Comments {
    @SerializedName("postId")
    var postId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("body")
    var body: String? = null
}