package com.example.fknweeb.repos

import com.example.fknweeb.domain.IAnimeRepository
import com.example.fknweeb.domain.IApiClient

class AnimeRepository(private val apiClient: IApiClient) : IAnimeRepository {

    override suspend fun makeRequest(anime: String)=
        apiClient.findAnimeByName(anime)


    override suspend fun loadTrendingAnime() = apiClient.loadTrendingAnime()
}