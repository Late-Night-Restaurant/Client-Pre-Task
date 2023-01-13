package com.example.kotlin_study_pretask

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.Field

data class Book(
    @SerializedName("header")
    val header: String,
    @SerializedName("body")
    val body: String


)
