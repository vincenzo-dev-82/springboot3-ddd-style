package com.vincenzo.product.shared

data class ErrorSource(
    val code: ErrorCode,
    val message: String,
    val info: Map<String, Any?>? = null,
    val cause: Throwable? = null,
)
