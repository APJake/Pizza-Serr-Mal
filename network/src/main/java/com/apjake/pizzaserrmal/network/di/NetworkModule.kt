package com.apjake.pizzaserrmal.network.di

import android.content.Context
import com.apjake.pizzaserrmal.network.service.PizzaApi
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
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
        fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
            val client = OkHttpClient.Builder()
                .addInterceptor(ChuckerInterceptor(context))
                .build()
            return Retrofit.Builder()
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com/")
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }


}