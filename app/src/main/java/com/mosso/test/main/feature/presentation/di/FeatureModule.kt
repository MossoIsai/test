package com.mosso.test.main.feature.presentation.di

import com.mosso.test.main.feature.data.repository.GetCategoriesRepositoryImp
import com.mosso.test.main.feature.domain.repository.GetCategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FeatureModule {

    @Binds
    fun bindRepository(repositoryImp: GetCategoriesRepositoryImp): GetCategoriesRepository
}