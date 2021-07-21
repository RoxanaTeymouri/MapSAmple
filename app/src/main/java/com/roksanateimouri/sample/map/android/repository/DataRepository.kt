package com.roksanateimouri.sample.map.android.repository

import com.roksanateimouri.sample.map.android.pojo.model.MyTaxi
import com.roksanateimouri.sample.map.android.repository.network.NetworkRepository

/**
 * All needed api's are gathered here
 *
 * @property networkRepository
 */
class DataRepository(
    private val networkRepository: NetworkRepository

) : DataRepositoryInterface {

    override suspend fun getVehicles(): MyTaxi {
        val data = networkRepository.getVehicles()
        return data
    }

}