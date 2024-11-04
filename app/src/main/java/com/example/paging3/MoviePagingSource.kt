package com.example.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState


class MoviePagingSource(
    private val movieApi: MovieApi,
    private val apiKey: String
) : PagingSource<Int, Movie>() {

     override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = movieApi.getPopularMovies(apiKey, nextPageNumber)
            LoadResult.Page(
                data = response.movies,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.movies.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        TODO("Not yet implemented")
    }
}