package com.iphoto.plus.net

import java.lang.RuntimeException

class RequestException constructor(
    response:String
): RuntimeException(response)
