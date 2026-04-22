package domain.di

import domain.usecase.GetBreedsUseCase
import org.koin.dsl.module

fun getSearchDomainModule() = module {
    factory { GetBreedsUseCase(get()) }
}