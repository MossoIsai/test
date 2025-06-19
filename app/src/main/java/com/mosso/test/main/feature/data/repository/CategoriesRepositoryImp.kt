package com.mosso.test.main.feature.data.repository

import com.mosso.test.main.core.data.Result
import com.mosso.test.main.core.domain.ServiceFactory
import com.mosso.test.main.core.presentation.handlerErrorMessage
import com.mosso.test.main.feature.data.response.CategoryDetailResponse
import com.mosso.test.main.feature.data.service.GetCategoriesServices
import com.mosso.test.main.feature.domain.repository.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoriesRepositoryImp @Inject constructor(
    serviceFactory: ServiceFactory
) : CategoriesRepository {

    private val service = serviceFactory.makeConnectionApiService(GetCategoriesServices::class.java)

    override suspend fun getCategories(): Flow<Result<List<String>>> {
        return flow {
            val response = service.getCategories()
            if (response.isSuccessful) {
                emit(Result.Success(response.body()))
            } else {
                emit(Result.Error(response.message()))
            }
        }.catch {
            emit(Result.Error(it.handlerErrorMessage()))
        }
    }

    override suspend fun getCategoryDetail(category: String): Flow<Result<CategoryDetailResponse>> {
        return flow {
            val response = service.getCategoryDetail(category)
            if (response.isSuccessful) {
                emit(Result.Success(response.body()))
            } else {
                emit(Result.Error(response.message()))
            }
        }.catch {
            emit(Result.Error(it.handlerErrorMessage()))
        }
    }
}