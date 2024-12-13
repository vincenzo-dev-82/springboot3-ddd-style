package com.vincenzo.product.domain.car

interface CarRepository {
    fun findAll(): List<Car>

    fun findById(id: Long): Car?

    fun save(car: Car): Car

    fun delete(car: Car)
}
