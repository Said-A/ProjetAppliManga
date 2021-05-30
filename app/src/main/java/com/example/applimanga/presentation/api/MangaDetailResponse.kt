package com.example.applimanga.presentation.api

data class MangaDetailResponse(
        val image_url:String,
        val title:String,
        val synopsis:String,
        val score:Float,
        val status:String,
        val serializations: List<MangeDetail>

)

data class MangeDetail(
        val mal_id:Int,
        val type:String
)
