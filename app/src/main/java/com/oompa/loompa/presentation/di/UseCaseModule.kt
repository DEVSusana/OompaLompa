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

    @Provides
    @Singleton
    fun provideDeleteListOompaUseCase(
        oompaRepository: OompaRepository
    ): DeleteListOompaUseCase{
        return DeleteListOompaUseCase(oompaRepository)
    }

    @Provides
    @Singleton
    fun provideGetDetailsOompaUseCase(
        oompaRepository: OompaRepository
    ): GetDetailsOompaUseCase{
        return GetDetailsOompaUseCase(oompaRepository)
    }

    @Provides
    @Singleton
    fun provideGetListOompaUseCase(
        oompaRepository: OompaRepository
    ): GetListOompaUseCase{
        return GetListOompaUseCase(oompaRepository)
    }

    @Provides
    @Singleton
    fun provideSaveDetailsOompaUseCase(
        oompaRepository: OompaRepository
    ): SaveDetailsOompaUseCase{
        return SaveDetailsOompaUseCase(oompaRepository)
    }

    @Provides
    @Singleton
    fun provideSaveListOompaUseCase(
        oompaRepository: OompaRepository
    ): SaveListOompaUseCase{
        return SaveListOompaUseCase(oompaRepository)
    }


}