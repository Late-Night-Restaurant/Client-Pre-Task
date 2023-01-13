package com.example.kotlin_study_pretask.DTO

data class Body(
    val items: Items,
    val numOfRows: String,
    val pageNo: String,
    val totalCount: String
)