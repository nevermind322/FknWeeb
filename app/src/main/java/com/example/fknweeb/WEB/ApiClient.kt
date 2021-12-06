package com.example.fknweeb.WEB

import android.util.Log
import com.example.fknweeb.ApiError
import com.example.fknweeb.ApiResponse
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.kitsu.KitsuMapper
import com.example.fknweeb.domain.IApiClient


class ApiClient : IApiClient {


    override suspend fun findAnimeByName(name: String): ApiResponse {

        val response = NetworkLayer.apiService.getAnimeByName(name)

        try {
            if (response.body()?.data == null) return ApiResponse.Failure(ApiError.ServerError)
            if (response.body()?.data!!.isEmpty()) return ApiResponse.Failure(ApiError.NotFound)
            return ApiResponse.Success(KitsuMapper.mapAll(response.body()!!.data))
        } catch (e: Exception) {

            return ApiResponse.Failure(ApiError.UnknownError)

        }
    }

    override suspend fun loadTrendingAnime(): ApiResponse {
        val response = NetworkLayer.apiService.getTrendingAnime()
        try {
            if (response.body()?.data == null) return ApiResponse.Failure(ApiError.ServerError)
            if (response.body()?.data!!.isEmpty()) return ApiResponse.Failure(ApiError.NotFound)
            return ApiResponse.Success(KitsuMapper.mapAll(response.body()!!.data))
        } catch (e: Exception) {

            return ApiResponse.Failure(ApiError.UnknownError)

        }
    }
}

