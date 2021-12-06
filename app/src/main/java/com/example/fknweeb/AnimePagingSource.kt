package com.example.fknweeb

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.fknweeb.WEB.NetworkLayer.apiService
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.kitsu.KitsuResponse
import java.lang.Exception

class AnimePagingSource(private val query: String) : PagingSource<String, KitsuData>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, KitsuData> {



        if (params.key == null) {
            return try {
                val response = apiService.getPage("anime", mapOf("filter[text]" to query))
                Log.e("dazezdes", response.body()!!.links?.get("next").getOffset().toString())
                return LoadResult.Page(
                    data = response.body()!!.data,
                    nextKey = response.body()!!.links?.get("next"),
                    prevKey = response.body()!!.links?.get("prev"),
                )
            } catch (E: Exception) {
                LoadResult.Error(E)
            }
        } else {
            return try {
                Log.e("dazezdes", params.key!!.getOffset().toString())
                val response = apiService.getPage(
                    "anime",
                    mapOf(
                        "filter[text]" to query,
                        "page[limit]" to "10",
                        "page[offset]" to params.key.getOffset().toString()
                    )
                )
                return LoadResult.Page(
                    data = response.body()!!.data,
                    nextKey = response.body()!!.links?.get("next"),
                    prevKey = response.body()!!.links?.get("prev"),
                )
            } catch (E: Exception) {
                LoadResult.Error(E)
            }
        }
    }


    override fun getRefreshKey(state: PagingState<String, KitsuData>): String? {
        return null
    }
}

fun String?.getOffset(): Int {

    val nextOrPrev = this

    if (nextOrPrev != null) {
        val list = nextOrPrev.split("=")
        val offset  = list[list.size-1]
        return offset.toInt()

    }
    Log.e("nu", "2")
    return -1
}


