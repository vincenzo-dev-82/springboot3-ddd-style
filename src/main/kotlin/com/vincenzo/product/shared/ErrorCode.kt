package com.vincenzo.product.shared

enum class ErrorCode(
    val desc: String,
) {
    ST00("시스템 에러입니다."),
    DT01("데이터가 없습니다."),
    DT02("데이터가 존재합니다."),
}
