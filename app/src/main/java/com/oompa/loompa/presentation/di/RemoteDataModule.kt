package com.oompa.loompa.presentation.di

import com.oompa.loompa.data.api.OompaApiService
import com.oompa.loompa.data.repository.dataSourceImpl.OompaRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    @Singleton
    fun provideOompaRemoteDataSource(
        oompaApiService: OompaApiService
    ): OompaRemoteDataSourceImpl {
        return OompaRemoteDataSourceImpl(oompaApiService)
    }

}