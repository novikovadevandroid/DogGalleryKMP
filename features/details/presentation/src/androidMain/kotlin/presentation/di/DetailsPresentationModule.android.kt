package presentation.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import presentation.DetailsViewModel

actual fun getDetailsPresentationModule(): Module = module {
    viewModel { DetailsViewModel(get()) }
}