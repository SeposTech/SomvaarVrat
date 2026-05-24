package com.spiritual.somvaarvrat.di

import com.spiritual.somvaarvrat.data.repository.ShivAartiRepositoryImp
import com.spiritual.somvaarvrat.domain.repository.ShivAartiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindShivAartiRepository(shivAartiRepositoryImp: ShivAartiRepositoryImp): ShivAartiRepository
}