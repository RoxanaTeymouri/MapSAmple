package com.roksanateimouri.sample.map.android.features.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.roksanateimouri.sample.map.android.base.BaseViewModel
import com.roksanateimouri.sample.map.android.pojo.ViewNavigationEnum
import com.roksanateimouri.sample.map.android.retrofit.RetrofitInterface
import com.roksanateimouri.sample.map.android.utils.coroutinesExceptionHandler
import kotlinx.coroutines.launch

/**
 * Splash page ViewModel
 *
 * @property dataRepository
 */
class SplashViewModel(private val dataRepository: RetrofitInterface) : BaseViewModel() {

    private val liveData = MutableLiveData<ViewNavigationEnum>()

    fun decideNextView(networkAvailable: Boolean) =
        viewModelScope.launch(coroutinesExceptionHandler(exceptionLiveData)) {
            liveData.postValue(
                when {
                    networkAvailable -> ViewNavigationEnum.MAP
                    dataRepository.getVehicles().poiList.isNotEmpty() -> ViewNavigationEnum.VEHICLE_LIST
                    else ->  throw IllegalArgumentException("There is a problem in fetching data")
                }
            )
        }
}