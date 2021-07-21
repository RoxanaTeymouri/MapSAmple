package com.roksanateimouri.sample.map.android.retrofit

import com.roksanateimouri.sample.map.android.pojo.model.MyTaxi
import retrofit2.http.GET

/**
 * Retrofit main interface
 *
 */
interface RetrofitInterface {

    @GET("?p1Lat=53.694865&p1Lon=9.757589&p2Lat=53.394655&p2Lon=10.099891")
    suspend fun getVehicles(): MyTaxi
}