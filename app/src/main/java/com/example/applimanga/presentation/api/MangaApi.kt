package com.example.applimanga.presentation.api

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApi {

    @GET("top/anime")
    fun getAnimelist(): Call<MangaResponse>

    @GET("top/manga")
    fun getMangalist(): Call<MangaResponse>

    @GET("manga/{mal_id}")
    fun getMangaDetailList(@Path("mal_id") id:Int) : Call<MangaDetailResponse>

}