package com.vincenzo.product.shared.exception

import com.vincenzo.product.shared.ErrorCode
import com.vincenzo.product.shared.ErrorSource

open class CustomException(
    val errorSource: ErrorSource,
) : RuntimeException(errorSource.message)

class DataNotFoundException : CustomException {
    constructor(message: String, id: Long) : super(ErrorSource(ErrorCode.DT01, message, mapOf("id" to id)))
}

class DataAlreadyExistsException : CustomException {
    constructor(message: String, id: Long) : super(ErrorSource(ErrorCode.DT01, message, mapOf("id" to id)))
}
