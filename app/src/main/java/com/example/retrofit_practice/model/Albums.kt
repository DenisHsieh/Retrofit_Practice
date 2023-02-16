package com.example.retrofit_practice.model

import com.google.gson.annotations.SerializedName

class Albums {
    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null
}