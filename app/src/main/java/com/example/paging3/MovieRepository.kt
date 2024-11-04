package com.example.paging3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MovieApi) {
    fun getPopularMovies(apiKey: String): Pager<Int, Movie> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(movieApi, apiKey) }
        )
    }
}