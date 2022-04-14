package com.apjake.pizzaserrmal.network.service

import PizzaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private lateinit var api: PizzaApi

    fun getApi(): PizzaApi {

        /*
        Initialize ApiService if not initialized yet
        val httpClient = OkHttpClient().newBuilder().addInterceptor(
        ChuckerInterceptor()
        ).build()
        */


        if (!::api.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com")
//                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            api= retrofit.create(PizzaApi::class.java)
        }

        return api
    }
}