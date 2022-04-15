package com.apjake.pizzaserrmal.appdata.di

import com.apjake.pizzaserrmal.appdata.repository.PizzaRepositoryImpl
import com.apjake.pizzaserrmal.domain.models.repository.PizzaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    @Singleton
    fun bindPizzaRepository(pizzaRepositoryImpl: PizzaRepositoryImpl): PizzaRepository
}