package com.oompa.loompa.presentation.di

import android.app.Application
import androidx.room.Room
import com.oompa.loompa.data.db.OompaLoompaDAO
import com.oompa.loompa.data.db.OompaLoompaDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application): OompaLoompaDataBase {
        return Room.databaseBuilder(app, OompaLoompaDataBase::class.java, "oompa_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(oompaLoompaDataBase: OompaLoompaDataBase): OompaLoompaDAO {
        return oompaLoompaDataBase.getOompaLoompaDAO()
    }


}