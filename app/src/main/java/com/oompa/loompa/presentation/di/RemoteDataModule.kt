package com.oompa.loompa.presentation.di

import com.oompa.loompa.data.api.OompaApiService
import com.oompa.loompa.data.repository.dataSource.OompaLocalDataSource
import com.oompa.loompa.data.repository.dataSourceImpl.OompaRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideOompaRemoteDataSource(
        oompaApiService: OompaApiService
    ): OompaRemoteDataSourceImpl {
        return OompaRemoteDataSourceImpl(oompaApiService)
    }

}