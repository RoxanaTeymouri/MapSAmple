package com.roksanateimouri.sample.map.android.base.di

import com.roksanateimouri.sample.map.android.repository.DataRepository
import com.roksanateimouri.sample.map.android.repository.DataRepositoryInterface
import com.roksanateimouri.sample.map.android.repository.network.NetworkRepository
import org.koin.dsl.module

/**
 * Represents module of koin that the scopes inside it creates instance of [DataRepository] & [NetworkRepository].
 * this module injects [NetworkRepository] in [DataRepository].
 */
val dataRepositoryModule = module {
    single<DataRepositoryInterface> {
        DataRepository(get())
    }

    single {
        NetworkRepository(get())
    }

}
