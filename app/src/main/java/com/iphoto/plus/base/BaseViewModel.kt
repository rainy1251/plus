package com.iphoto.plus.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {
 
 
    //运行在UI线程的协程
//    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
//        try {
//            withTimeout(15 * 1000) {
//                block()
//            }
//        } catch (e: Exception) {
//            //此处接收到BaseRepository里的request抛出的异常
//            //根据业务逻辑自行处理代码...
//
//        }
//    }
 
    
}