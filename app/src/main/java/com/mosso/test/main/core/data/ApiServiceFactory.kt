package com.mosso.test.main.core.data

import com.mosso.test.main.core.domain.ServiceFactory
import retrofit2.Retrofit
import javax.inject.Inject

class ApiServiceFactory @Inject constructor(
    private val retrofit: Retrofit
) : ServiceFactory {
    override fun <T> makeConnectionApiService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}