package com.mosso.test.main.feature.domain.usecase

import com.mosso.test.main.core.data.Result
import com.mosso.test.main.core.domain.usecase.BaseUseCase
import com.mosso.test.main.core.presentation.CoreModule.IoDispatcher
import com.mosso.test.main.feature.data.response.CategoryDetailResponse
import com.mosso.test.main.feature.domain.repository.CategoriesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCategoryDetailUseCase @Inject constructor(
    private val repository: CategoriesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : BaseUseCase<String, Result<CategoryDetailResponse>>() {

    override fun execute(params: String): Flow<Result<CategoryDetailResponse>> =
        flow<Result<CategoryDetailResponse>> {
            repository.getCategoryDetail(params).collect {
                when (it) {
                    is Result.Error -> emit(Result.Error(it.exception))
                    is Result.Success -> emit(Result.Success(it.body))
                }
            }
        }.flowOn(dispatcher)
}