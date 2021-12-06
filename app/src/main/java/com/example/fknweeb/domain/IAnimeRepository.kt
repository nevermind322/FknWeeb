package com.example.fknweeb.domain

import com.example.fknweeb.ApiResponse
import com.example.fknweeb.domain.AnimeInfo

interface IAnimeRepository {
    suspend fun makeRequest(anime: String): ApiResponse
    suspend fun loadTrendingAnime(): ApiResponse
}