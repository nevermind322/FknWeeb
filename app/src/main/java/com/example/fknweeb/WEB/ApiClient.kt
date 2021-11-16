package com.example.fknweeb.WEB

import com.example.fknweeb.KitsuMapper
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.domain.IApiClient

class ApiClient : IApiClient {



    override suspend fun findAnimeByName(name: String): AnimeInfo {

        val response = NetworkLayer.apiService.getAnimeByName(name)

        return KitsuMapper().map(response.body()!!.data[0])
    }
}

