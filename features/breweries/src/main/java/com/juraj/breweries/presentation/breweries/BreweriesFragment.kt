package com.juraj.breweries.presentation.breweries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.juraj.breweries.databinding.FragmentBreweriesBinding
import com.juraj.breweries.presentation.breweries.adapter.BreweriesAdapter
import com.juraj.breweries.presentation.breweries.adapter.BreweryComparator
import com.juraj.common.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweriesFragment : BaseFragment<BreweriesViewModel, FragmentBreweriesBinding>() {

    override val viewModel: BreweriesViewModel by viewModel()
    override fun inflateBinding(inflater: LayoutInflater) =
        FragmentBreweriesBinding.inflate(inflater)

    private val pagingAdapter by lazy { BreweriesAdapter(BreweryComparator, viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adapter = pagingAdapter

        binding.breweriesList.apply {
            adapter = pagingAdapter
            layoutManager = LinearLayoutManager(context)
        }

        pagingAdapter.addLoadStateListener {
            binding.isAppending = it.append is LoadState.Loading
            binding.isLoading = it.refresh is LoadState.Loading

            if (it.append is LoadState.Error) {
                (it.append as LoadState.Error).error.message?.let { it1 -> viewModel.setError(it1) }
            } else if (it.append is LoadState.Loading) {
                viewModel.resetError()
            }

            if (it.refresh is LoadState.Error) {
                (it.refresh as LoadState.Error).error.message?.let { it1 -> viewModel.setError(it1) }
            } else if (it.refresh is LoadState.Loading) {
                viewModel.resetError()
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.breweries.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }
}