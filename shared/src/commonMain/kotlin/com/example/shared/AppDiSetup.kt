package com.example.shared

import data.di.getSearchDataModule
import domain.di.getSearchDomainModule
import network.di.getCoreNetworkModule
import org.koin.core.context.startKoin
import presentation.di.getSearchPresentationModule

fun initKoin() {
    startKoin {
        modules(
            getCoreNetworkModule(),
            getSearchDataModule(),
            getSearchDomainModule(),
            getSearchPresentationModule()
        )
    }
}