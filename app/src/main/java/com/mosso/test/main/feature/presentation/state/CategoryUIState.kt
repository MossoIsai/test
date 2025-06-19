package com.mosso.test.main.feature.presentation.state

sealed interface CategoryUIState {
    data object Loading : CategoryUIState
    data class Error(val errorMessage: String) : CategoryUIState
    data class Success(val categoriesList: List<String>) : CategoryUIState
}