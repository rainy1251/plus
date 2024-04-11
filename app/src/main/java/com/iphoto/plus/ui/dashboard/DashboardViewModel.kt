package com.iphoto.plus.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iphoto.plus.base.BaseViewModel
import com.iphoto.plus.bean.PhoneBean
import com.iphoto.plus.net.HttpRequest

class DashboardViewModel : BaseViewModel() {

    private val sendCodeData by lazy {
        MutableLiveData<String>()
    }

    fun sendPhoneCode(phoneBean: PhoneBean) : LiveData<String>{
        HttpRequest.execute{
            val sendCode = it.sendCode(phoneBean)
            sendCodeData.value = sendCode.message
        }
        return sendCodeData
    }
}