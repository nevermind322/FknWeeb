package com.example.fknweeb.kitsu

import android.os.Parcelable
import com.example.fknweeb.KitsuData

import kotlinx.parcelize.Parcelize

@Parcelize
data class KitsuResponse(
    val data: List<KitsuData>,
    val links: Map<String, String>?,
    val meta: Map<String, Int>?
) : Parcelable
