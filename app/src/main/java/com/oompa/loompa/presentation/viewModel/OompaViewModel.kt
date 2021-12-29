package com.oompa.loompa.presentation.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.oompa.loompa.data.Utils.Resource
import com.oompa.loompa.data.model.ApiResponse
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import retrofit2.Response

class OompaViewModel(
    private val app: Application,
    private val deleteListOompaUseCase: DeleteListOompaUseCase,
    private val getDetailsOompaUseCase: GetDetailsOompaUseCase,
    private val getListOompaUseCase: GetListOompaUseCase,
    private val saveDetailsOompaUseCase: SaveDetailsOompaUseCase,
    private val saveListOompaUseCase: SaveListOompaUseCase
) : AndroidViewModel(app) {

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

    val getListOompa: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()

    fun getOompaLoompaList(page: Int) = viewModelScope.launch(Dispatchers.IO) {
        getListOompa.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {

                val apiResult = getListOompaUseCase.execute(page)

                getListOompa.postValue(apiResult)
            } else {
                getListOompa.postValue(Resource.Error("Internet is not available"))
            }

        } catch (e: Exception) {
            getListOompa.postValue(Resource.Error(e.message.toString()))
        }

    }

    val getDetailOompa: MutableLiveData<Resource<OompaDetail>> = MutableLiveData()
    val getDetail = mutableStateOf(getDetailOompa.value)

    fun getOompaLoompaDetail(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        getDetailOompa.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = getDetailsOompaUseCase.execute(id)
                getDetail.value = apiResult
                getDetailOompa.postValue(apiResult)
            } else {
                getDetailOompa.postValue(Resource.Error("Internet is not available"))
            }

        } catch (e: Exception) {
            getDetailOompa.postValue(Resource.Error(e.message.toString()))
        }

    }


    //local data
    fun saveOoompaLoompa(oompaDetail: OompaDetail) = viewModelScope.launch {
        saveDetailsOompaUseCase.execute(oompaDetail)
    }

    fun getSaveListOompa() = liveData {
        saveListOompaUseCase.execute().collect {
            emit(it)
        }
    }

    fun deleteOompa(oompaDetail: OompaDetail) = viewModelScope.launch {
        deleteListOompaUseCase.execute(oompaDetail)
    }


}