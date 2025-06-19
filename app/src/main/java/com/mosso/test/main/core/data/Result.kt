package com.mosso.test.main.core.data

sealed  class Result<T> {
    data class Success<T>(val body:T?): Result<T>()
    data class Error<T>(val exception: String): Result<T>()
}