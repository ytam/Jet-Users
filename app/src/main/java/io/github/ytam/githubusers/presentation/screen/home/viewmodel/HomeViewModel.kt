package io.github.ytam.githubusers.presentation.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ytam.githubusers.domain.usecase.UserUseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    userUseCases: UserUseCases,
) : ViewModel() {

    val getAllUsers = userUseCases.getUsersUseCase()
}
