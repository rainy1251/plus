package com.iphoto.plus.ui.dashboard

import com.iphoto.plus.base.BaseRepository
import com.iphoto.plus.bean.Banner
import com.iphoto.plus.bean.PhoneBean
import com.iphoto.plus.bean.ResponseBean
import com.iphoto.plus.net.Response
import com.iphoto.plus.net.RetrofitClient

class DashboardRepository : BaseRepository() {

    suspend fun sendCode(phoneBean: PhoneBean): Response<ResponseBean> = request {
        RetrofitClient.apiService.sendCode(phoneBean)
    }
}