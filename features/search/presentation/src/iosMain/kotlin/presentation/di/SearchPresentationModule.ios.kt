package presentation.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.SearchViewModel

private val viewModelModule = module {
    factory { SearchViewModel(get()) }
}

actual fun getSearchPresentationModule(): Module = viewModelModule

class SearchViewModelProvider : KoinComponent {

    fun provideSearchViewModel(): SearchViewModel = get()
}