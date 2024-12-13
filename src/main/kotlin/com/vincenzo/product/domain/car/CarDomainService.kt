package com.vincenzo.product.domain.car

import org.springframework.stereotype.Service

@Service
class CarDomainService(
    private val carRepository: CarRepository,
) {
    fun createCar(car: Car): Car = carRepository.save(car)
}
