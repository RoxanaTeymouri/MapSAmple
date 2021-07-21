package com.roksanateimouri.sample.map.android.features.vehiclelist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.roksanateimouri.sample.map.android.pojo.model.Poi

/**
 * DiffUtils for [VehicleListAdapter]
 *
 */
class VehicleListDiffUtils : DiffUtil.ItemCallback<Poi>() {
    override fun areItemsTheSame(oldItem: Poi, newItem: Poi) =
        oldItem.coordinate.latitude == newItem.coordinate.latitude && oldItem.coordinate.longitude == newItem.coordinate.longitude  && oldItem.fleetType == newItem.fleetType && oldItem.heading == newItem.heading

    override fun areContentsTheSame(oldItem: Poi, newItem: Poi) =
        oldItem.coordinate.latitude == newItem.coordinate.latitude && oldItem.coordinate.longitude == newItem.coordinate.longitude && oldItem.fleetType == newItem.fleetType && oldItem.heading == newItem.heading
}