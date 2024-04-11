package com.iphoto.plus.net

data class Response<T> (
    val code: Int,
    val message: String,
    val data: T
)