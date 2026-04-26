package di

import domain.repository.ImageRepository
import org.koin.dsl.module
import repository.ImageRepositoryImpl

fun getDetailsDataModule() = module {
    single<ImageRepository> { ImageRepositoryImpl(get()) }
}