package com.roksanateimouri.sample.map.android.pojo.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyTaxi(
    val poiList: List<Poi>
)
@JsonClass(generateAdapter = true)
data class Poi(
    val coordinate: Coordinate,
    val fleetType: String,
    val heading: Double,
    val id: Int
)
@JsonClass(generateAdapter = true)
data class Coordinate(
    val latitude: Double,
    val longitude: Double
)