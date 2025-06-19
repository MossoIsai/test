package com.mosso.test.main.feature.presentation.state

import com.mosso.test.main.feature.data.response.CategoryDetailResponse

interface CategoryDetailUIState {
    data object Loading : CategoryDetailUIState
    data class Error(val errorMessage: String) : CategoryDetailUIState
    data class Success(val categoryDetail: CategoryDetailResponse? = null) : CategoryDetailUIState
}