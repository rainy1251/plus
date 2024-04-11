package com.iphoto.plus.bean

data class ResponseBean(
    val  code :Int,
    val  message :String ,
    val data : Data
)

data class Data(
   val string: String
)
