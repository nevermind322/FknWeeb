package com.example.fknweeb.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.fknweeb.AnimePagingSource
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.kitsu.KitsuMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PageViewModel() : ViewModel() {


    fun getAnime(query: String): Flow<PagingData<AnimeInfo>> {

        return Pager(
            config = PagingConfig(10, 3),
            pagingSourceFactory = { AnimePagingSource(query) }
        ).flow.map { it -> it.map { KitsuMapper.map(it) } }.cachedIn(viewModelScope)
    }
}