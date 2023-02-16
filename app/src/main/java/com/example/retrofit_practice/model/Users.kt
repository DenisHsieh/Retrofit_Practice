package com.example.retrofit_practice.model

import com.google.gson.annotations.SerializedName

class Users {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("username")
    var username: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("address")
    var address: Address? = null

    @SerializedName("phone")
    var phone: String? = null

    @SerializedName("website")
    var website: String? = null

    @SerializedName("company")
    var company: Company? = null
}

class Address {
    @SerializedName("street")
    var street: String? = null

    @SerializedName("suite")
    var suite: String? = null

    @SerializedName("city")
    var city: String? = null

    @SerializedName("zipcode")
    var zipcode: String? = null

    @SerializedName("geo")
    var geo: Geo? = null

    override fun toString(): String {
        return "street: ${street}, suite: ${suite}, city: ${city}, zipcode: ${zipcode}, " +
                "geo-lat: ${geo?.lat}, geo-lng: ${geo?.lng}"
    }
}

class Geo {
    @SerializedName("lat")
    var lat: Double? = null

    @SerializedName("lng")
    var lng: Double? = null
}

class Company {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("catchPhrase")
    var catchPhrase: String? = null

    @SerializedName("bs")
    var bs: String? = null

    override fun toString(): String {
        return "company-name: ${name}, company-catchPhrase: ${catchPhrase}, company-bs: $bs"
    }
}