package com.apjake.pizzaserrmal.network.di

import com.apjake.pizzaserrmal.network.service.PizzaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object Provide {

        @Provides
        @Singleton
        fun providePizzaService(retrofit: Retrofit): PizzaApi =
             retrofit.create(PizzaApi::class.java)


        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com/")

                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }


}