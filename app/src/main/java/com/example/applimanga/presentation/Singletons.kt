package com.example.applimanga.presentation

import com.example.applimanga.presentation.api.MangaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object{
        val apiManga: MangaApi = Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MangaApi::class.java)
    }
}