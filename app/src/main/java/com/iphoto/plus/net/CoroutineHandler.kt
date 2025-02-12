package com.iphoto.plus.net

import android.util.Log
import com.iphoto.plus.utils.JsonUtil
import com.iphoto.plus.utils.ToastUtil
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import retrofit2.HttpException
import java.net.ConnectException
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

object CoroutineHandler : AbstractCoroutineContextElement(CoroutineExceptionHandler),
    CoroutineExceptionHandler {

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        Log.d("ResponseException","请求异常"+exception.message.toString())
        Log.d("ResponseException","请求异常name"+exception.javaClass.name)
        // 处理
        when (exception.javaClass.name) {
            ConnectException::class.java.name -> ToastUtil.show("请求异常，请检查网络")
            RequestException::class.java.name -> {
                // 处理服务器错误

                val httpResult =
                    JsonUtil.json2Object(exception.message.toString(), Response::class.java)

                when (httpResult.code) {
                    400 -> ToastUtil.show("请求异常，服务器异常")
                }
            }

            HttpException::class.java.name -> {
                ToastUtil.show(exception.message.toString())
            }
        }

        context.cancel()
    }
}