package com.mosso.test.main.feature.domain.repository

interface ServiceApiFactory {
    fun <T> makeConnectionApiService(serviceClass: Class<T>): T
}