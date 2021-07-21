package com.roksanateimouri.sample.map.android.features.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.roksanateimouri.sample.map.android.base.BaseViewModel
import com.roksanateimouri.sample.map.android.pojo.model.MyTaxi
import com.roksanateimouri.sample.map.android.retrofit.RetrofitInterface
import com.roksanateimouri.sample.map.android.utils.coroutinesExceptionHandler
import kotlinx.coroutines.launch

/**
 * Map page ViewModel
 *
 * @property repository
 */
class MapsViewModel(private val repository: RetrofitInterface) : BaseViewModel() {
    private val liveData = MutableLiveData<MyTaxi>()

    /**
     * Fetches vehicles data from server to show them on map
     *
     *
     */
    fun getVehicles() = viewModelScope.launch(coroutinesExceptionHandler(exceptionLiveData)) {
        val vehicles = repository.getVehicles()
        liveData.postValue(vehicles)
    }

    /**
     * Turns the MutableLiveData to LiveData to prevent accidental postValue on the Fragment
     *
     * @return liveData of type [VehiclesData]
     */
    fun getVehicleLiveData(): LiveData<MyTaxi> = liveData
}