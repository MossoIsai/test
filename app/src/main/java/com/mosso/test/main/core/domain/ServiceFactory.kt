package com.mosso.test.main.core.domain

interface ServiceFactory {
    fun <T> makeConnectionApiService(serviceClass: Class<T>): T
}