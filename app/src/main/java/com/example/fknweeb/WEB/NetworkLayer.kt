package com.example.fknweeb.WEB

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkLayer {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://kitsu.io/api/edge/")
        .build()

    val apiService = retrofit.create<KitsuEndpoints>()
}