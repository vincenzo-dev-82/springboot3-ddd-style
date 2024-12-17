package com.vincenzo.product.infrastructure

import com.vincenzo.product.domain.aDummy
import com.vincenzo.product.domain.car.Car
import com.vincenzo.product.infrastructure.persistence.CarJpaRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CarJpaRepositoryTest {
    @Autowired
    private lateinit var carJpaRepository: CarJpaRepository

    @Test
    fun `save and retrieve car`() {
        val car = Car.aDummy()
        val savedCar = carJpaRepository.save(car)
        val foundCar = carJpaRepository.findById(savedCar.id!!)

        assertTrue(foundCar.isPresent)
        assertEquals("BMW", foundCar.get().brandName)
    }
}
