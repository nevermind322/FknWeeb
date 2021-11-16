package com.example.fknweeb

import android.os.Parcelable
import androidx.annotation.Dimension
import com.example.fknweeb.domain.AnimeInfo
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@Parcelize
data class KitsuData(
    val id: Int,
    val type: String,
    val attributes: Attributes,
    val links: Map<String, String>
  //  val relationships: Map<String, Map<String, String>>
) : Parcelable


@Parcelize
data class Attributes(
    @SerializedName("createdAt") var createdAt: String,
    @SerializedName("updatedAt") var updatedAt: String,
    @SerializedName("slug") var slug: String,
    @SerializedName("synopsis") var synopsis: String,
    @SerializedName("description") var description: String,
    @SerializedName("coverImageTopOffset") var coverImageTopOffset: Int,
    @SerializedName("titles") var titles: Map<String, String>,
    @SerializedName("canonicalTitle") var canonicalTitle: String,
    @SerializedName("abbreviatedTitles") var abbreviatedTitles: List<String>,
    @SerializedName("averageRating") var averageRating: String,
    @SerializedName("ratingFrequencies") var ratingFrequencies: Map<Int, Int>,
    @SerializedName("userCount") var userCount: Int,
    @SerializedName("favoritesCount") var favoritesCount: Int,
    @SerializedName("startDate") var startDate: String,
    @SerializedName("endDate") var endDate: String,
    @SerializedName("nextRelease") var nextRelease: String,
    @SerializedName("popularityRank") var popularityRank: Int,
    @SerializedName("ratingRank") var ratingRank: Int,
    @SerializedName("ageRating") var ageRating: AgeRating,
    @SerializedName("ageRatingGuide") var ageRatingGuide: String,
    @SerializedName("subtype") var subtype: Subtype,
    @SerializedName("status") var status: Status,
    @SerializedName("tba") var tba: String,
    @SerializedName("posterImage") var posterImage: PosterImage,
    @SerializedName("coverImage") var coverImage: CoverImage,
    @SerializedName("episodeCount") var episodeCount: Int,
    @SerializedName("episodeLength") var episodeLength: Int,
    @SerializedName("totalLength") var totalLength: Int,
    @SerializedName("youtubeVideoId") var youtubeVideoId: String,
    @SerializedName("showType") var showType: String,
    @SerializedName("nsfw") var nsfw: Boolean
) : Parcelable

@Parcelize
data class PosterImage(
    val tiny: String,
    val small: String,
    val medium: String,
    val large: String,
    val meta : ImageMeta
) : Parcelable

@Parcelize
data class CoverImage(
    val tiny: String,
    val small: String,
    val large: String,
    val meta : ImageMeta
) : Parcelable

@Parcelize
data class ImageMeta(val dimensions: Map<String, Dim>) : Parcelable

@Parcelize
data class Dim(val width: Int, val height: Int) : Parcelable

enum class AgeRating{
    G, PG, R, R18
}

enum class Subtype{
    ONA, OVA, TV, movie, music, special
}

enum class Status{
    current, finished, tbd, unreleased, upcoming
}

