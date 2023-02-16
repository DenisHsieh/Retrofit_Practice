package com.example.retrofit_practice.model

import com.google.gson.annotations.SerializedName

class Photos {
    @SerializedName("albumId")
    var albumId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String? = null
}