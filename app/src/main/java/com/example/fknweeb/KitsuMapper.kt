package com.example.fknweeb

import com.example.fknweeb.domain.AnimeInfo

class KitsuMapper() {

    fun map(data: KitsuData) : AnimeInfo{

        val name = data.attributes.canonicalTitle

        val image = data.attributes.posterImage.large

        return AnimeInfo(name, image)
    }
}