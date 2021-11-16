package com.example.fknweeb.vms

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.domain.AnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeViewModel(private val repo: AnimeRepository) : ViewModel() {

    var res = MutableLiveData<AnimeInfo>()

    suspend fun find(input: String) {

        val answer = repo.makeRequest(input)
        res.value = answer

    }
}