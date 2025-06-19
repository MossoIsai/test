package com.mosso.test.main.feature.data.service

import retrofit2.Response
import retrofit2.http.GET


interface GetCategoriesServices {
   @GET("categories")
    suspend fun getCategories(): Response<List<String>>
}