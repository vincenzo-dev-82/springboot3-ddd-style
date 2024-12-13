package com.vincenzo.product.infrastructure.persistence

import com.vincenzo.product.domain.car.Car
import com.vincenzo.product.domain.car.CarRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class CarRepositoryImpl(
    private val carJpaRepository: CarJpaRepository,
) : CarRepository {
    override fun findAll(): List<Car> = carJpaRepository.findAll()

    override fun findById(id: Long): Car? = carJpaRepository.findByIdOrNull(id)

    override fun save(car: Car): Car = carJpaRepository.save(car)

    override fun delete(car: Car) = carJpaRepository.delete(car)
}
