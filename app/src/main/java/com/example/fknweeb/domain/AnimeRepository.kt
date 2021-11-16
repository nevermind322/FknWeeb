package com.example.fknweeb.domain

class AnimeRepository(private val apiClient: IApiClient) {

    suspend fun makeRequest(anime: String) =
        apiClient.findAnimeByName(anime)

}