package com.juraj.breweries.presentation.brewerydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juraj.common.base.BaseViewModel
import com.juraj.domain.breweries.GetBreweriesUseCase
import com.juraj.model.model.Brewery
import kotlinx.coroutines.launch

class BreweryDetailViewModel(
    private val getBreweriesUseCase: GetBreweriesUseCase,
): BaseViewModel() {
    
    private val _brewery = MutableLiveData<Brewery>()
    val brewery: LiveData<Brewery> = _brewery

    fun loadBreweryById(breweryId: String) {
        viewModelScope.launch { 
            _brewery.value = getBreweriesUseCase.getBrewery(breweryId)
        }
    }
}