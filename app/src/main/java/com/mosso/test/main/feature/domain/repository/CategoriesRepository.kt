package com.mosso.test.main.feature.domain.repository

import com.mosso.test.main.core.data.Result
import com.mosso.test.main.feature.data.response.CategoryDetailResponse
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    suspend fun getCategories(): Flow<Result<List<String>>>

    suspend fun getCategoryDetail(category:String): Flow<Result<CategoryDetailResponse>>
}