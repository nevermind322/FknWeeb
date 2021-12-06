package com.example.fknweeb.domain

import com.example.fknweeb.ApiResponse

interface IApiClient {
    suspend fun findAnimeByName(name: String) : ApiResponse

    suspend fun loadTrendingAnime() : ApiResponse
}