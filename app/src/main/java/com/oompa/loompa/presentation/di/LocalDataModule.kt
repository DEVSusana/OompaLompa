package com.oompa.loompa.presentation.di

import com.oompa.loompa.data.db.OompaLoompaDAO
import com.oompa.loompa.data.repository.dataSource.OompaLocalDataSource
import com.oompa.loompa.data.repository.dataSourceImpl.OompaLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(oompaLoompaDAO: OompaLoompaDAO):OompaLocalDataSource{
        return OompaLocalDataSourceImpl(oompaLoompaDAO)
    }

}