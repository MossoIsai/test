package com.mosso.test.main.core.presentation

import okio.IOException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.handlerErrorMessage(): String {
    val errorMessage = when (this) {
        is HttpException -> HTTP_EXCEPTION
        is SocketTimeoutException -> SOCKET_TIMEOUT_EXCEPTION
        is UnknownHostException -> UNKNOWN_HOST_EXCEPTION
        is ConnectException -> CONNECTION_EXCEPTION
        is IOException -> IO_EXCEPTION
        else -> this.message.toString()
    }
    return errorMessage
}


const val HTTP_EXCEPTION = "Something went wrong, try again later."
const val SOCKET_TIMEOUT_EXCEPTION = "Connection timeout"
const val IO_EXCEPTION = "Please check your connection and try again."
const val UNKNOWN_HOST_EXCEPTION = "Please check your Internet connection and try again."
const val CONNECTION_EXCEPTION = "Failed to connect to api"