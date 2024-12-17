package com.vincenzo.product.applicaitoin.service

import com.vincenzo.product.applicaitoin.dto.CarResources
import com.vincenzo.product.applicaitoin.mapper.CarMapper
import com.vincenzo.product.domain.car.Car
import com.vincenzo.product.domain.car.CarDomainService
import org.springframework.stereotype.Service

@Service
class CarService(
    private val carDomainService: CarDomainService,
) {
    fun create(request: CarResources.CarRequestDTO): Car = carDomainService.createCar(CarMapper.toEntity(request))
}
