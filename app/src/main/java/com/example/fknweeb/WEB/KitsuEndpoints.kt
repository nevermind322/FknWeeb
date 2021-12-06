package com.example.fknweeb.WEB

import com.example.fknweeb.kitsu.KitsuResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface KitsuEndpoints {

    @GET("anime")
    suspend fun getAnimeByName(@Query("filter[text]") name: String): Response<KitsuResponse>

    @GET("trending/anime")
    suspend fun getTrendingAnime(): Response<KitsuResponse>

    @GET("{object}")
    suspend fun getPage(
        @Path("object") _object: String,
        @QueryMap opts: Map<String, String>
    ): Response<KitsuResponse>
}