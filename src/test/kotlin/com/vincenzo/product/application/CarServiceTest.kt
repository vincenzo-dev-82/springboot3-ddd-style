package com.kakaopay.ad.domain.advertisement.service

import com.vincenzo.product.applicaitoin.service.CarService
import com.vincenzo.product.domain.aDummy
import com.vincenzo.product.domain.car.Car
import com.vincenzo.product.domain.car.CarRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.kotlin.whenever

class CarServiceTest {
    private val carRepository: CarRepository = mock(CarRepository::class.java)
    private val carService = CarService(carRepository)

    private lateinit var actual: Car

    @BeforeEach
    fun setUp() {
        actual = Car.aDummy()
    }

    @DisplayName("모든 차량을 조회한다")
    @Test
    fun `get all cars`() {
        val carList =
            listOf(
                Car.aDummy(),
                Car(alias = "Car2", type = Car.Type.CAR, plateNumber = "456DEF", brandName = "Ford", modelName = "F-150"),
            )
        `when`(carRepository.findAll()).thenReturn(carList)

        val result = carService.getAllCars()

        assertEquals(2, result.size)
        verify(carRepository, times(1)).findAll()
    }

    @DisplayName("차량을 입력한다")
    @Test
    fun validateAdvertisementName() {
        // Given
        whenever(carRepository.save(actual)).thenReturn(actual)

        // When
        val expected = carRepository.save(actual)

        // Then
        assertEquals(actual, expected)
    }
}
