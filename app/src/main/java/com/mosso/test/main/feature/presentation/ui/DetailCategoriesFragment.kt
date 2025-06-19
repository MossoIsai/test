package com.mosso.test.main.feature.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mosso.test.databinding.DetailCategoriesFragmentBinding
import com.mosso.test.main.feature.presentation.state.CategoryDetailUIState
import com.mosso.test.main.feature.presentation.viewmodel.CategoriesVieModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailCategoriesFragment : Fragment() {


    private var _binding: DetailCategoriesFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CategoriesVieModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailCategoriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //test with animal
        viewModel.getCategoryDetail("animal")
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryDetailUIState.collect { uiState ->
                    when (uiState) {
                        is CategoryDetailUIState.Error -> Log.d("Error: ", uiState.errorMessage)
                        CategoryDetailUIState.Loading -> Log.d("Cargando: ", "Cargando---->")
                        is CategoryDetailUIState.Success -> {
                            Log.d("DETAIL ", uiState.categoryDetail.toString())
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}