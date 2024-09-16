package com.juraj.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.juraj.common.BR
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseFragment<TViewModel : BaseViewModel, TViewBinding : ViewDataBinding> :
    Fragment() {

    private var _binding: TViewBinding? = null
    val binding: TViewBinding
        get() = requireNotNull(_binding) {
            "Binding can't be accessed before onViewCreated() or after onViewDestroyed()"
        }

    abstract val viewModel: TViewModel

    abstract fun inflateBinding(inflater: LayoutInflater): TViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater).also {
            it.lifecycleOwner = viewLifecycleOwner
            it.setVariable(BR.viewModel, viewModel)
        }
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.navigate.collectLatest {
                when(it) {
                    is NavigationCommand.NavigateBack -> {
                        findNavController().navigateUp()
                    }
                    is NavigationCommand.NavigateTo -> {
                        findNavController().navigate(it.directions)
                    }
                }
            }
        }
    }
}