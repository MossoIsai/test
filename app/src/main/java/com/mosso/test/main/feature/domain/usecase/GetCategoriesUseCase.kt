package com.mosso.test.main.feature.domain.usecase

import com.mosso.test.main.core.data.Result
import com.mosso.test.main.core.domain.usecase.BaseUseCase
import com.mosso.test.main.core.presentation.CoreModule.IoDispatcher
import com.mosso.test.main.feature.domain.repository.GetCategoriesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: GetCategoriesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : BaseUseCase<Unit, Result<List<String>>>() {

    override fun execute(params: Unit): Flow<Result<List<String>>> =
        flow<Result<List<String>>> {
            repository.getCategories().collect {
                when (it) {
                    is Result.Error -> emit(Result.Error(it.exception))
                    is Result.Success -> emit(Result.Success(it.body))
                }
            }
        }.flowOn(dispatcher)
}