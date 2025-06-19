package com.mosso.test.main.feature.data.service

import com.mosso.test.main.feature.domain.repository.ServiceApiFactory
import retrofit2.Retrofit
import javax.inject.Inject

class ServiceApiFactoryImp
@Inject constructor(
    private val retrofit: Retrofit
) : ServiceApiFactory {
    override fun <T> makeConnectionApiService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}