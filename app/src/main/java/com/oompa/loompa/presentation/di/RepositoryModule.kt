package com.oompa.loompa.presentation.di

import com.oompa.loompa.data.repository.OompaRepositoryImpl
import com.oompa.loompa.data.repository.dataSource.OompaLocalDataSource
import com.oompa.loompa.data.repository.dataSource.OompaRemoteDataSource
import com.oompa.loompa.domain.repository.OompaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideOompaRepository(
        oompaRemoteDataSource: OompaRemoteDataSource,
        oompaLocalDataSource: OompaLocalDataSource

    ): OompaRepository {
        return OompaRepositoryImpl(
            oompaRemoteDataSource,
            oompaLocalDataSource
        )
    }

}