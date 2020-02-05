package com.kingtech.cardfinder.modules.ui.card_input

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kingtech.cardfinder.data.entities.CardResult
import com.kingtech.cardfinder.data.network.RetrofitClient
import com.kingtech.cardfinder.data.repository.CardServiceRepository
import com.kingtech.cardfinder.utils.Constant
import kotlinx.coroutines.launch

class CardInputViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        const val TAG = "CardInputViewModel"
    }

    private val loadingState = MutableLiveData<Boolean>()
    private val successState = MutableLiveData<CardResult>()
    private val errorState = MutableLiveData<String>()

    val cardInputText = MutableLiveData<String>("")
    private val context = application.applicationContext

    private val cardService = RetrofitClient.service()
    private val cardServiceRepository = CardServiceRepository(cardService)

    val loadingLiveData: LiveData<Boolean>
        get() = loadingState

    val success: LiveData<CardResult>
        get() = successState

    val errorLiveData: LiveData<String>
        get() = errorState

    fun getCardDetails() {
        if (cardInputText.value!!.isEmpty()) {
            Toast.makeText(context, "input cannot be empty", Toast.LENGTH_SHORT).show()
            Log.i(TAG, "Was returned")
            return
        }

        val url =
            "https://findbinnumbers.p.rapidapi.com/?bin=${cardInputText.value}&format=${Constant.TYPE_JSON}"
        loadingState.value = true
        viewModelScope.launch {
            try {
                val res = cardServiceRepository.getCardDetails(url)
                if (res.isSuccessful) {
                    loadingState.value = false
                    successState.value = res.body()
                } else {
                    loadingState.value = false
                    successState.value = null
                    errorState.value = res.errorBody()?.string()
                    Log.i(TAG, "error state is ${res.errorBody()?.string()}")
                }
            } catch (e: Throwable) {
                Log.i(TAG, "Caught an exception ${e.message}")
                loadingState.value = false
                successState.value = null
                errorState.value = e.message
            }
        }
    }
}
