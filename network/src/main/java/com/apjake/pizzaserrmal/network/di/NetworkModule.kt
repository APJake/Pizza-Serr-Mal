package com.apjake.pizzaserrmal.network.di

import PizzaApi
import android.content.Context
import com.apjake.pizzaserrmal.appdata.PizzaNetworkDataSource
import com.apjake.pizzaserrmal.network.datasource.PizzaNetworkDataSourceImpl
import com.apjake.pizzaserrmal.network.response.Pizza
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object Provider {

        @Provides
        @Singleton
        fun providePizzaService(retrofit: Retrofit): PizzaApi =
            retrofit.create(PizzaApi::class.java)


        @Provides
        @Singleton
        fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
            val httpClient = OkHttpClient().newBuilder().addInterceptor(
                ChuckerInterceptor(context)
            ).build()
            return Retrofit.Builder()
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    @Binds
    @Singleton
    abstract fun bindPizzaNetworkDataSource(dataSource: PizzaNetworkDataSourceImpl): PizzaNetworkDataSource
}