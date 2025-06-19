package com.mosso.test.main.feature.domain.repository

import com.mosso.test.main.core.data.Result
import com.mosso.test.main.feature.data.models.CategoriesResponse
import kotlinx.coroutines.flow.Flow

interface GetCategoriesRepository {

    suspend fun getCategories(): Flow<Result<List<String>>>
}