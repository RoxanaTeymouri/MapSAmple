package com.roksanateimouri.sample.map.android.repository.network

import com.roksanateimouri.sample.map.android.repository.DataRepositoryInterface
import com.roksanateimouri.sample.map.android.retrofit.RetrofitInterface

/**
 * All Retrofit interfaces will be gathered here
 *
 * @property retrofitInterface
 */
class NetworkRepository(private val retrofitInterface: DataRepositoryInterface) :
    RetrofitInterface by retrofitInterface