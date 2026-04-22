package data.di

import data.repository.BreedsRepositoryImpl
import domain.repository.BreedsRepository
import org.koin.dsl.module

fun getSearchDataModule() = module {
    single<BreedsRepository> { BreedsRepositoryImpl(get()) }
}