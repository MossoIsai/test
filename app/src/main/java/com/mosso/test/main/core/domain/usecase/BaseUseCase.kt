package com.mosso.test.main.core.domain.usecase

import kotlinx.coroutines.flow.Flow

@Suppress("UNCHECKED_CAST")
abstract class BaseUseCase<Params, Output> {

    abstract fun execute(params: Params): Flow<Output>

    open fun execute(): Flow<Output> = execute(Unit as Params)
}