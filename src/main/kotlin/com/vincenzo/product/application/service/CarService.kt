package com.vincenzo.product.application.service

import com.vincenzo.product.application.dto.CarResources
import com.vincenzo.product.application.mapper.CarMapper
import com.vincenzo.product.domain.car.CarRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CarService(
    private val carRepository: CarRepository,
) {
    @Transactional(readOnly = true)
    fun getAllCars(): List<CarResources.CarResponseDTO> {
        val cars = carRepository.findAll()
        return cars.map { CarMapper.toDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getCarById(id: Long): CarResources.CarResponseDTO? {
        val car = carRepository.findById(id)
        return car?.let { CarMapper.toDTO(it) }
    }

    @Transactional
    fun create(request: CarResources.CarRequestDTO): CarResources.CarResponseDTO {
        // 비즈니스 규칙은 DomainService나 Entity에 위임
        val car = CarMapper.toEntity(request)
        val savedCar = carRepository.save(car)
        return CarMapper.toDTO(savedCar)
    }

    @Transactional
    fun updateCar(request: CarResources.CarRequestDTO): CarResources.CarResponseDTO {
        // 비즈니스 규칙은 DomainService나 Entity에 위임
        val updatedCar = CarMapper.toEntity(request)
        val savedCar = carRepository.save(updatedCar)
        return CarMapper.toDTO(savedCar)
    }

    @Transactional
    fun deleteCar(id: Long) {
        // 비즈니스 규칙은 DomainService나 Entity에 위임
        val car = carRepository.findById(id)
        car?.let { carRepository.delete(car) }
    }
}
