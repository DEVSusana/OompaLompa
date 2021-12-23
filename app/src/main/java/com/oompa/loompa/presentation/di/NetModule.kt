package com.oompa.loompa.presentation.di

import com.oompa.loompa.BuildConfig
import com.oompa.loompa.data.api.OompaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetModule{
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.URL_BASE)
            .build()
    }

    @Provides
    @Singleton
    fun provideOompaAPIService(retrofit: Retrofit):OompaApiService{
        return retrofit.create(OompaApiService::class.java)
    }



}