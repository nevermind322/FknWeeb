package com.example.fknweeb.domain

interface IApiClient {
    suspend fun findAnimeByName(name: String) : AnimeInfo?

}