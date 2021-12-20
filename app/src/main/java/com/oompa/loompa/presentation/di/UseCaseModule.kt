package com.oompa.loompa.presentation.di

import com.oompa.loompa.domain.repository.OompaRepository
import com.oompa.loompa.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideDeleteListOompaUseCase(
        oompaRepository: OompaRepository
    ): DeleteListOompaUseCase{
        return DeleteListOompaUseCase(oompaRepository)
    }

    @Singleton
    @Provides
    fun provideGetDetailsOompaUseCase(
        oompaRepository: OompaRepository
    ): GetDetailsOompaUseCase{
        return GetDetailsOompaUseCase(oompaRepository)
    }

    @Singleton
    @Provides
    fun provideGetListOompaUseCase(
        oompaRepository: OompaRepository
    ): GetListOompaUseCase{
        return GetListOompaUseCase(oompaRepository)
    }

    @Singleton
    @Provides
    fun provideSaveDetailsOompaUseCase(
        oompaRepository: OompaRepository
    ): SaveDetailsOompaUseCase{
        return SaveDetailsOompaUseCase(oompaRepository)
    }

    @Singleton
    @Provides
    fun provideSaveListOompaUseCase(
        oompaRepository: OompaRepository
    ): SaveListOompaUseCase{
        return SaveListOompaUseCase(oompaRepository)
    }


}