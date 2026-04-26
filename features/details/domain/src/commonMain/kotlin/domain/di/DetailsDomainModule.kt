package domain.di

import domain.usecase.GetImagesUseCase
import org.koin.dsl.module

fun getDetailsDomainModule() = module {
    factory { GetImagesUseCase(get()) }
}