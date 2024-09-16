package com.juraj.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val _navigate = MutableSharedFlow<NavigationCommand>()
    internal val navigate = _navigate.asSharedFlow()

    fun navigate(navDirections: NavDirections) {
        viewModelScope.launch {
            _navigate.emit(NavigationCommand.NavigateTo(navDirections))
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _navigate.emit(NavigationCommand.NavigateBack)
        }
    }
}