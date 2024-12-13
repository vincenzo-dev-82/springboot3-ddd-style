package com.kakaopay.ad.domain.advertisement.service

import com.vincenzo.product.domain.aDummy
import com.vincenzo.product.domain.car.Car
import com.vincenzo.product.domain.car.CarDomainService
import com.vincenzo.product.domain.car.CarRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class CarDomainServiceTest {
    private val carRepository: CarRepository = mock()
    private val carDomainService = CarDomainService(carRepository)

    private lateinit var actual: Car

    @BeforeEach
    fun setUp() {
        actual = Car.aDummy()
    }

    @DisplayName("차량을 입력한다")
    @Test
    fun validateAdvertisementName() {
        // Given
        whenever(carDomainService.createCar(actual)).thenReturn(actual)

        // When
        val expected = carDomainService.createCar(actual)

        // Then
        assertEquals(actual, expected)
    }
}
