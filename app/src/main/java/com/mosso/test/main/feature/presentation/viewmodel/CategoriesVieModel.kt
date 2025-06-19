package com.mosso.test.main.feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosso.test.main.core.data.Result
import com.mosso.test.main.feature.domain.usecase.GetCategoriesUseCase
import com.mosso.test.main.feature.presentation.state.CategoryUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesVieModel @Inject constructor(
    private val useCase: GetCategoriesUseCase
) : ViewModel() {

    val categoryUState: StateFlow<CategoryUIState> =
        useCase.execute().map {
            when (it) {
                is Result.Error -> CategoryUIState.Error(it.exception)
                is Result.Success -> CategoryUIState.Success(it.body ?: emptyList())
            }
        }.catch { error ->
            CategoryUIState.Error(error.message.toString())
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = CategoryUIState.Loading
        )

    fun callCategories() = viewModelScope.launch {
        useCase.execute()
    }
}