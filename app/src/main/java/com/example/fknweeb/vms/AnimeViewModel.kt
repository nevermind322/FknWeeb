package com.example.fknweeb.vms

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.fknweeb.AnimePagingSource
import com.example.fknweeb.ApiResponse
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.domain.IAnimeRepository
import com.example.fknweeb.kitsu.KitsuMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AnimeViewModel(private val repo: IAnimeRepository) : ViewModel() {

    var res = MutableLiveData<ApiResponse>()

    var trending = MutableLiveData<ApiResponse>()


    suspend fun find(input: String) {
        val answer = repo.makeRequest(input)
        res.value = answer
    }


    suspend fun loadTrendingAnime() {
        val answer = repo.loadTrendingAnime()
        trending.value = answer
    }

    fun getAnime(query: String): Flow<PagingData<AnimeInfo>> {
        Log.e("itut", query)
        return Pager(
            config = PagingConfig(10, 3),
            pagingSourceFactory = { AnimePagingSource(query) }
        ).flow.map { it -> it.map {
            Log.d("AnimeViewModel", KitsuMapper.map(it).toString())
            KitsuMapper.map(it) } }.cachedIn(viewModelScope)
    }
}