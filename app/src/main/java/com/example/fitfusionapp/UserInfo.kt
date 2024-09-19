package com.example.fitfusionapp

data class userInfo(
    val type : Int,
    val icon : Int,
    val title: String,
    val steps: Int?,
    val progress: Float?,
    val sleepData: List<Float>? = null,
    val image : Int?,
)
