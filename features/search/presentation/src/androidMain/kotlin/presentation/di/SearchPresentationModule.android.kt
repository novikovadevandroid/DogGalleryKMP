package presentation.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import presentation.SearchViewModel

actual fun getSearchPresentationModule(): Module =
    module {
        viewModel { SearchViewModel(get()) }
    }
