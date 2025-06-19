package com.mosso.test.main.feature.data.service

import com.mosso.test.main.feature.data.response.CategoryDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GetCategoriesServices {
    @GET("categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("random?category={category}")
    suspend fun getCategoryDetail(
        @Path("category") categoryKey: String
    ): Response<CategoryDetailResponse>
}