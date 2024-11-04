package com.example.paging3

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: String,
    val name: String,
    val description: String?,
    @SerializedName("poster") val poster: Poster?
)