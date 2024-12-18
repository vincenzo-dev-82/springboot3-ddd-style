package com.vincenzo.product.application.mapper

import com.vincenzo.product.application.dto.CarResources
import com.vincenzo.product.domain.car.Car
import org.apache.logging.log4j.util.Strings

object CarMapper {
    fun toDTO(car: Car): CarResources.CarResponseDTO =
        CarResources.CarResponseDTO(
            id = car.id!!,
            alias = car.alias,
            type = car.type.name, // Enum 값을 문자열로 변환
            plateNumber = car.plateNumber,
            brandName = car.brandName,
            modelName = car.modelName,
            brandImage = car.brandImage ?: Strings.EMPTY,
        )

    fun toEntity(request: CarResources.CarRequestDTO): Car =
        Car(
            alias = request.alias,
            type = Car.Type.fromValue(request.type), // 문자열을 Enum으로 변환
            plateNumber = request.plateNumber,
            brandName = request.brandName,
            modelName = request.modelName,
            brandImage = request.brandImage,
        )
}
