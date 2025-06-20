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
import androidx.recyclerview.widget.LinearLayoutManager
import com.mosso.test.databinding.CategoriesListFragmentBinding
import com.mosso.test.main.feature.presentation.adapter.CategoryAdapter
import com.mosso.test.main.feature.presentation.state.CategoryUIState
import com.mosso.test.main.feature.presentation.viewmodel.CategoriesVieModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesListFragment : Fragment() {

    private var _binding: CategoriesListFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CategoriesVieModel by viewModels()
    private lateinit var categoriesAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CategoriesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.callCategories()
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryUState.collect { uiState ->
                    when (uiState) {
                        is CategoryUIState.Error -> Log.d("Error: ", uiState.errorMessage)
                        CategoryUIState.Loading -> Log.d("Cargando: ", "Cargando---->")
                        is CategoryUIState.Success -> {
                            categoriesAdapter = CategoryAdapter(uiState.categoriesList)
                            binding.rvCategoriesList.apply {
                                layoutManager = LinearLayoutManager(this.context)
                                adapter = categoriesAdapter
                            }
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