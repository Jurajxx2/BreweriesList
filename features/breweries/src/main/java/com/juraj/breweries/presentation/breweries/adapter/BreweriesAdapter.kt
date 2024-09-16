package com.juraj.breweries.presentation.breweries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.juraj.breweries.databinding.ItemBreweryBinding
import com.juraj.breweries.presentation.breweries.BreweriesViewModel
import com.juraj.breweries.presentation.brewerydetail.BreweryDetailViewModel
import com.juraj.common.BR
import com.juraj.model.model.Brewery

class BreweriesAdapter(diffCallback: DiffUtil.ItemCallback<Brewery>, val viewModel: BreweriesViewModel) :
    PagingDataAdapter<Brewery, BreweryViewHolder>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BreweryViewHolder {
        val binding = ItemBreweryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BreweryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.setVariable(BR.viewModel, viewModel)
        holder.binding.brewery = item
    }
}