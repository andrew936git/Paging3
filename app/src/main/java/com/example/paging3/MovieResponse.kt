package com.example.paging3

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("docs") val movies: List<Movie>
)