package com.juraj.breweries.presentation.brewerydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.navArgs
import com.juraj.breweries.databinding.FragmentBreweryDetailBinding
import com.juraj.common.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweryDetailFragment: BaseFragment<BreweryDetailViewModel, FragmentBreweryDetailBinding>() {

    override val viewModel by viewModel<BreweryDetailViewModel>()
    override fun inflateBinding(inflater: LayoutInflater) = FragmentBreweryDetailBinding.inflate(inflater)
    private val args by navArgs<BreweryDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadBreweryById(args.breweryId)
    }
}