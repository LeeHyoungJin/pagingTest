package com.helrin.pagingtest.remote

open class BaseResponse {
    val ok: Boolean = false
    val msg: String = ""
}

data class LeeResponse<T>(val result: T) : BaseResponse()