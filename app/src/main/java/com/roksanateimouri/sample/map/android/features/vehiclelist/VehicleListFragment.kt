package com.roksanateimouri.sample.map.android.features.vehiclelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.roksanateimouri.sample.map.android.R
import com.roksanateimouri.sample.map.android.base.BaseFragment
import com.roksanateimouri.sample.map.android.features.vehiclelist.adapter.VehicleListAdapter
import kotlinx.android.synthetic.main.fragment_vehicle_list.*
import kotlinx.android.synthetic.main.view_item_toolbar_back.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Shows a list of previously fetched [com.roksanateimouri.sample.map.android.pojo.Vehicle]
 *
 */
class VehicleListFragment : BaseFragment() {

    private val viewModel: VehicleListViewModel by viewModel()
    private lateinit var adapter: VehicleListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vehicle_list, container, false)
    }

    override fun tryAgainDialogAction() {
        viewModel.getVehicles()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        txtTitle.text = getString(R.string.vehicle_list)
        observeErrorMessage(viewModel.getExceptionData())
        setUpRecyclerView()
        viewModel.getVehicleListLiveData().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        if (savedInstanceState == null)
            viewModel.getVehicles()
    }

    private fun setUpRecyclerView() {
        adapter = VehicleListAdapter()
        recycler.adapter = adapter
    }
}