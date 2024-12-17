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
        // Given
        val carList =
            listOf(
                Car.aDummy(),
                Car(
                    alias = "Car2",
                    type = Car.Type.CAR,
                    plateNumber = "456DEF",
                    brandName = "Ford",
                    modelName = "F-150",
                ),
            )
        whenever(carRepository.findAll()).thenReturn(carList)

        // When
        val result = carService.getAllCars()

        // Then
        assertEquals(2, result.size)
        verify(carRepository, times(1)).findAll()
    }

    /**
     *
     * When
     * - whenever 설정만으로도 로직은 이미 검증되지만, 호출 검증이 중요하다면 verify()를 추가 사용.
     *
     * Then
     * - 로직의 동작을 검증할 때는 assertEquals만 사용.
     * - 메서드 호출 여부를 검증할 때만 verify를 사용.
     *   - 특히 Mock 객체의 호출 여부를 검증할 때 필요.
     */
    @DisplayName("차량을 입력한다")
    @Test
    fun `save car`() {
        // Given
        whenever(carRepository.save(actual)).thenReturn(actual)

        // When
        val expected = carRepository.save(actual)

        // Then
        assertEquals(actual, expected)
        verify(carRepository, times(1)).save(actual) // save 메서드 호출 검증
    }
}
