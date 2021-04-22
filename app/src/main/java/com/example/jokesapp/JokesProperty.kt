package com.example.jokesapp

import android.os.Parcelable
import com.squareup.moshi.Json

data class JokesProperty(
    val id: Double,
    val type: String,
    val setup: String,
    val punchline : String,

   )