package com.vincenzo.product.applicaitoin

import com.vincenzo.product.applicaitoin.dto.CarResources
import com.vincenzo.product.applicaitoin.service.CarService
import com.vincenzo.product.domain.aDummy
import com.vincenzo.product.domain.car.Car
import com.vincenzo.product.domain.car.CarRepository
import org.apache.logging.log4j.util.Strings
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.lang.reflect.Field

class CarServiceTest {
    private val carRepository: CarRepository = mock()
    private val carService = CarService(carRepository)

    private lateinit var actual: Car

    @BeforeEach
    fun setUp() {
        actual = Car.Companion.aDummy()
        setIdUsingReflection(actual, 1L)
    }

    @DisplayName("모든 차량을 조회한다")
    @Test
    fun `get all cars`() {
        // Given
        val carList =
            listOf(
                Car(
                    alias = "TestCar",
                    type = Car.Type.CAR,
                    plateNumber = "123가1111",
                    brandName = "BMW",
                    modelName = "M1",
                    brandImage = Strings.EMPTY,
                ).also { setIdUsingReflection(it, 1L) },
                Car(
                    alias = "TestCar",
                    type = Car.Type.CAR,
                    plateNumber = "123가2222",
                    brandName = "BMW",
                    modelName = "M2",
                    brandImage = Strings.EMPTY,
                ).also { setIdUsingReflection(it, 2L) },
            )
        whenever(carRepository.findAll()).thenReturn(carList)

        // When
        val result = carService.getAllCars()

        // Then
        assertEquals(2, result.size)
        assertEquals("M1", result[0].modelName)
        assertEquals("M2", result[1].modelName)
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
        val requestDTO =
            CarResources.CarRequestDTO(
                alias = "TestCar",
                type = "CAR",
                plateNumber = "123가3333",
                brandName = "BMW",
                modelName = "M3",
                brandImage = Strings.EMPTY,
            )
        val actual = Car.Companion.aDummy()
        setIdUsingReflection(actual, 1L)
        whenever(carRepository.save(any())).thenReturn(actual)

        // When
        val result = carService.create(requestDTO)

        // Then
        assertEquals(actual.plateNumber, result.plateNumber)
        assertEquals("BMW", result.brandName)
        assertEquals("M3", result.modelName)
        verify(carRepository, times(1)).save(any())
    }

    private fun setIdUsingReflection(
        target: Any,
        id: Long,
    ) {
        val idField: Field = target::class.java.getDeclaredField("id")
        idField.isAccessible = true
        idField.set(target, id)
    }
}
