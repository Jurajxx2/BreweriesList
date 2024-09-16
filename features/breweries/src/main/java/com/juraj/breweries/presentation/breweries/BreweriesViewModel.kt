package com.juraj.breweries.presentation.breweries

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.juraj.common.base.BaseViewModel
import com.juraj.domain.breweries.GetBreweriesUseCase
import com.juraj.model.model.Brewery
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BreweriesViewModel(
    private val getBreweriesUseCase: GetBreweriesUseCase,
): BaseViewModel() {

    private val _loadBreweriesError = MutableStateFlow<String?>(null)
    val loadBreweriesError = _loadBreweriesError.asStateFlow()

    val breweries = Pager(PagingConfig(pageSize = 20)) {
        BreweriesPagingSource(getBreweriesUseCase)
    }.flow.cachedIn(viewModelScope)

    fun onBreweryClick(brewery: Brewery) {
        navigate(
            BreweriesFragmentDirections.actionBreweriesFragmentToBreweryDetailFragment(breweryId = brewery.id)
        )
    }

    fun setError(error: String) {
        viewModelScope.launch {
            _loadBreweriesError.emit(error)
        }
    }

    fun resetError() {
        viewModelScope.launch {
            _loadBreweriesError.emit(null)
        }
    }
}