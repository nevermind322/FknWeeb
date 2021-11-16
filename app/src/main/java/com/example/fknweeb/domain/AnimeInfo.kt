package com.example.fknweeb.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimeInfo(val name: String, val image: String?) : Parcelable


