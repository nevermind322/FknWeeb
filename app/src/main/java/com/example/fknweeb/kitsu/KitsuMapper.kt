package com.example.fknweeb.kitsu

import com.example.fknweeb.KitsuData
import com.example.fknweeb.domain.AnimeInfo

object KitsuMapper {

    fun map(data: KitsuData): AnimeInfo {

        val name = data.attributes.canonicalTitle

        val image = data.attributes.posterImage.medium

        return AnimeInfo(name, image)
    }

    fun mapAll(data: List<KitsuData>) = List<AnimeInfo>(data.size) { i -> map(data[i]) }
}