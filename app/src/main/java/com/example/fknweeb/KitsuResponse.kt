package com.example.fknweeb

import android.os.Parcelable

import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class KitsuResponse(
    val data: List<KitsuData>,
    val links: Map<String, String>,
    val meta: Map<String, Int>
) : Parcelable
