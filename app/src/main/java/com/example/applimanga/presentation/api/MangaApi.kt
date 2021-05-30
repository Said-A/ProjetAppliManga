package com.example.applimanga.presentation.api

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface MangaApi {

    @GET("top/anime")
    fun getAnimelist(): Call<MangaResponse>

    @GET("top/manga")
    fun getMangalist(): Call<MangaResponse>
}