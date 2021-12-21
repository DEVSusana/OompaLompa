package com.oompa.loompa.presentation.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.oompa.loompa.domain.usecase.*
import com.oompa.loompa.presentation.viewModel.OompaViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FactoryModule {
    @Provides
    @Singleton
    fun provideOompaViewModelFactory(
        application: Application,
        deleteListOompaUseCase: DeleteListOompaUseCase,
        getDetailsOompaUseCase: GetDetailsOompaUseCase,
        getListOompaUseCase: GetListOompaUseCase,
        saveDetailsOompaUseCase: SaveDetailsOompaUseCase,
        saveListOompaUseCase: SaveListOompaUseCase

    ): ViewModelProvider.Factory {
        return OompaViewModelFactory(
            application,
            deleteListOompaUseCase,
            getDetailsOompaUseCase,
            getListOompaUseCase,
            saveDetailsOompaUseCase,
            saveListOompaUseCase
        )
    }

}