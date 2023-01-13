package com.example.kotlin_study_pretask.DTO

data class DataDTO(
    val response: Response
){
    fun getTitle(): String{
        return response.body.items.item[0].title
    }
    fun getCharge(): String{
        return response.body.items.item[0].charge
    }
}