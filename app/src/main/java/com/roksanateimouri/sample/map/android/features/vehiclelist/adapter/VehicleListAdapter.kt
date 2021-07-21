package com.roksanateimouri.sample.map.android.features.vehiclelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roksanateimouri.sample.map.android.R
import com.roksanateimouri.sample.map.android.pojo.VehicleTypeEnum
import com.roksanateimouri.sample.map.android.pojo.model.Poi
import kotlinx.android.synthetic.main.view_vehicle_list_item.view.*

/**
 * VehiclesListAdapter that shows offline list of vehicles
 *
 */
class VehicleListAdapter :
    ListAdapter<Poi, VehicleListAdapter.VehicleListViewHolder>(VehicleListDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_vehicle_list_item, parent, false)
        return VehicleListViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleListViewHolder, position: Int) =
        holder.bind(getItem(position))

    /**
     * ViewHolder class for [VehicleListAdapter]
     *
     * @constructor takes the item view to be shown on VehicleList recycler view
     *
     *
     * @param itemView
     */
    inner class VehicleListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Poi) = with(itemView) {
            with(item) {
                txtType.text = context.getString(R.string.vehicle_type, fleetType)
                txtLat.text = context.getString(R.string.vehicle_lat, coordinate.latitude.toString())
                txtLng.text = context.getString(R.string.vehicle_lng, coordinate.longitude.toString())
                txtHeading.text = context.getString(R.string.vehicle_bearing, heading.toString())

                when (fleetType) {
                    VehicleTypeEnum.POOLING.type -> cardRoot.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorPrimary
                        )
                    )
                    VehicleTypeEnum.TAXI.type -> cardRoot.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorPlus
                        )
                    )
                    else -> cardRoot.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorPrimaryDark
                        )
                    )
                }
            }
        }
    }

}