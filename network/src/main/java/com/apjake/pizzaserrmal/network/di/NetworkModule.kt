package com.apjake.pizzaserrmal.network.di

import android.content.Context
import com.apjake.pizzaserrmal.appdata.PizzaNetworkDataSource
import com.apjake.pizzaserrmal.network.datasource.PizzaNetworkDataSourceImpl
import com.apjake.pizzaserrmal.network.service.PizzaApi
import com.apjake.pizzaserrmal.network.service.PizzaMockInterceptor
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Binds
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
import okhttp3.Interceptor
import okhttp3.Request


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
                .addInterceptor(PizzaMockInterceptor())
                .addInterceptor(Interceptor { chain ->
                    val request: Request =
                        chain.request().newBuilder()
                            .addHeader("X-RapidAPI-Host", "pizza-and-desserts.p.rapidapi.com")
                            .addHeader(
                                "X-RapidAPI-Key",
                                "50f4516edcmshdc7a5fad19e5b06p174665jsn43453f9bd0d5"
                            )
                            .build()
                    chain.proceed(request)
                })
                .build()
            return Retrofit.Builder()
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com/")
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    @Binds
    @Singleton
    abstract fun bindPizzaNetworkDataSource(pizzaNetworkDataSourceImpl: PizzaNetworkDataSourceImpl)
            : PizzaNetworkDataSource


}