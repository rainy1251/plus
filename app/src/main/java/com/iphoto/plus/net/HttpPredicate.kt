package com.iphoto.plus.net

fun interface HttpPredicate {
    suspend fun execute(api: ApiService)
}