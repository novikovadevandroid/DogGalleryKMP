package network.di

import network.client.HttpClientFactory
import network.service.ApiService
import org.koin.core.module.Module
import org.koin.dsl.module

fun getCoreNetworkModule(): Module = module {
    single {
        ApiService(HttpClientFactory.getInstance())
    }
}