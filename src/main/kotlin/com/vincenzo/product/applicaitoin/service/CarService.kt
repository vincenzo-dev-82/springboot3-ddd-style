package com.vincenzo.product.applicaitoin.service

import com.vincenzo.product.applicaitoin.dto.CarResources
import com.vincenzo.product.applicaitoin.mapper.CarMapper
import com.vincenzo.product.domain.car.Car
import com.vincenzo.product.domain.car.CarRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CarService(
    private val carRepository: CarRepository,
) {
    @Transactional(readOnly = true)
    fun getAllCars(): List<Car> = carRepository.findAll()

    @Transactional(readOnly = true)
    fun getCarById(id: Long): Car? = carRepository.findById(id)

    @Transactional
    fun create(request: CarResources.CarRequestDTO): Car {
        // 비즈니스 규칙은 DomainService나 Entity에 위임
        val car = CarMapper.toEntity(request)
        return carRepository.save(car)
    }

    @Transactional
    fun updateCar(car: Car): Car {
        // 비즈니스 규칙은 DomainService나 Entity에 위임
        return carRepository.save(car)
    }

    @Transactional
    fun deleteCar(car: Car) {
        // 비즈니스 규칙은 DomainService나 Entity에 위임
        carRepository.delete(car)
    }
}
