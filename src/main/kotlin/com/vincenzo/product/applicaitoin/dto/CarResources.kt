package com.vincenzo.product.applicaitoin.dto

class CarResources {
    data class CarRequestDTO(
        var alias: String?,
        var type: String,
        var plateNumber: String,
        var brandName: String,
        var modelName: String,
        var brandImage: String?,
    )

    data class CarResponseDTO(
        val id: Long,
        var alias: String?,
        var type: String,
        var plateNumber: String,
        var brandName: String,
        var modelName: String,
        var brandImage: String?,
    )

//    data class Owner()
}
