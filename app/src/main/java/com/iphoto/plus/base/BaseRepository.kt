package com.iphoto.plus.base

import android.util.Log
import com.iphoto.plus.net.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//TODO 暂时无用
open class BaseRepository {
 
    suspend fun <T : Any> request(call: suspend () ->Response<T>): Response<T> {
        return withContext(Dispatchers.IO) {
            call.invoke()
        }.apply {
            Log.e("接口返回数据---------->,${this.code}","")
            when (code) {
                0, 200 -> this
                100, 401 -> ""
                403 -> ""
                404 -> ""
                500 -> ""
                else -> ""

            }
        }
    }
 
}

