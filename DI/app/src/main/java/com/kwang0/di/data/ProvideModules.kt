package com.kwang0.di.data

import com.kwang0.di.data.repository.SecondRepository
import com.kwang0.di.data.repository.SecondRepositoryImpl
import org.koin.dsl.module

val secondRepositoryModule = module {
    single<SecondRepository> { SecondRepositoryImpl() }
}