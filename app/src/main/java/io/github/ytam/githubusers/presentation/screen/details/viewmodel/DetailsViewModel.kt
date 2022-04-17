package io.github.ytam.githubusers.presentation.screen.details.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ytam.githubusers.common.Constants
import io.github.ytam.githubusers.domain.model.UserDetail
import io.github.ytam.githubusers.domain.usecase.UserUseCases
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val userUseCases: UserUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedMovie: MutableStateFlow<UserDetail?> = MutableStateFlow(null)
    val selectedMovie: StateFlow<UserDetail?> = _selectedMovie

    init {
        savedStateHandle.get<String>(Constants.USER_DETAILS)?.let { coinId ->
            getUserDetails(coinId)
        }
    }

    fun getUserDetails(username: String) {
        viewModelScope.launch {
            userUseCases.getUsersFromDBUseCase.invoke(username = username).collect {
                _selectedMovie.value = it
            }
        }
    }
}
