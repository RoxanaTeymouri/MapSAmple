package com.roksanateimouri.sample.map.android.features.vehiclelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.roksanateimouri.sample.map.android.base.BaseViewModel
import com.roksanateimouri.sample.map.android.pojo.model.Poi
import com.roksanateimouri.sample.map.android.retrofit.RetrofitInterface
import com.roksanateimouri.sample.map.android.utils.coroutinesExceptionHandler
import kotlinx.coroutines.launch

/**
 * Fetches data needed by the VehicleList page
 *
 * @property repository
 */
class VehicleListViewModel(private val repository: RetrofitInterface) : BaseViewModel() {
    private val liveData = MutableLiveData<List<Poi>>()

    fun getVehicles() = viewModelScope.launch(coroutinesExceptionHandler(exceptionLiveData)) {
        val data = repository.getVehicles().poiList
        liveData.postValue(data)
    }
    fun getVehicleListLiveData(): LiveData<List<Poi>> = liveData
}