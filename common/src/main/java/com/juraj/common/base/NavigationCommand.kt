package com.juraj.common.base

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class NavigateTo(val directions: NavDirections) : NavigationCommand()
    data object NavigateBack : NavigationCommand()
}