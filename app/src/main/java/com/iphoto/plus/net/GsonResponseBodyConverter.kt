package com.iphoto.plus.net

import android.util.Log
import com.iphoto.plus.utils.JsonUtil
import okhttp3.ResponseBody
import retrofit2.Converter
import java.lang.reflect.Type

class GsonResponseBodyConverter<T>(
    private val type: Type
) : Converter<ResponseBody, T> {

    override fun convert(value: ResponseBody): T {
        val response = value.string()
        val httpResult = JsonUtil.json2Object(response, Response::class.java)
        // 这里是定义成code 200为正常，不正常则抛出之前定义好的异常，在自定义的协程异常处理类中处理
        Log.d("response","response: ${httpResult.message}===${httpResult.code}")
        return if (httpResult.code ==0) {
            JsonUtil.json2Object<T>(response, type)
        } else {
            throw RequestException(response)
        }
    }
}