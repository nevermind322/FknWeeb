package com.example.fknweeb.WEB

import com.example.fknweeb.KitsuResponse
import com.example.fknweeb.domain.AnimeInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KitsuEndpoints {

    @GET("anime")
    suspend fun getAnimeByName(@Query("filter[text]") name : String) : Response<KitsuResponse>

}