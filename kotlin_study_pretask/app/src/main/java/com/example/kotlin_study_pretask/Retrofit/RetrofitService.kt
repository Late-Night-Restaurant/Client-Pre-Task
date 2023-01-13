package com.example.kotlin_study_pretask.Retrofit

import com.example.kotlin_study_pretask.BuildConfig
import com.example.kotlin_study_pretask.DTO.DataDTO
import com.example.kotlin_study_pretask.DTO.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {
//
    @Headers("accept: application/json")
    @GET("${BuildConfig.BASE_URL}${BuildConfig.GET_PATH}")
    fun getBookData(
        @Query("serviceKey") serviceKey: String?,
        @Query("numOfRows") numOfRows: String?,
        @Query("pageNo") pageNo: String?
    ): Call<DataDTO>


}