package com.example.shared.di

import data.di.getSearchDataModule
import di.getDetailsDataModule
import domain.di.getDetailsDomainModule
import domain.di.getSearchDomainModule
import network.di.getCoreNetworkModule
import org.koin.core.context.startKoin
import presentation.di.getDetailsPresentationModule
import presentation.di.getSearchPresentationModule

fun initKoin() {
    startKoin {
        modules(
            getCoreNetworkModule(),
            getSearchDataModule(),
            getSearchDomainModule(),
            getSearchPresentationModule(),

            getDetailsDataModule(),
            getDetailsDomainModule(),
            getDetailsPresentationModule()
        )
    }
}