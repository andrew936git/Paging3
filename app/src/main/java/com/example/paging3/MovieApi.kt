package com.example.paging3

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {
    @GET("v1.4/movie")
    suspend fun getPopularMovies(
        @Header("X-API-KEY") apiKey: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 20,
        @Query("sort") sort: String = "-year"
    ): MovieResponse
}