package com.example.paging3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    repository: MovieRepository
) : ViewModel() {

    companion object {
        private const val API_KEY = "PR0YK95-NS843SP-MXN0CC1-S2MCG0Z"
    }

    val movies = repository.getPopularMovies(API_KEY).flow.cachedIn(viewModelScope)
}