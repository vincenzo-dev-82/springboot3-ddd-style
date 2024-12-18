package com.vincenzo.product.presentation

import com.fasterxml.jackson.databind.ObjectMapper
import com.vincenzo.product.application.dto.CarResources
import com.vincenzo.product.application.service.CarService
import com.vincenzo.product.presentation.controller.CarController
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * 주요 포인트
 * 1. @WebMvcTest:
 * - CarController만 테스트하기 위해 사용됩니다.
 * - MockMvc를 통해 HTTP 요청과 응답을 검증합니다.
 *
 * 2. @MockBean:
 * - CarService를 Mock으로 설정하여 서비스 레이어의 실제 구현 대신 Mock 동작을 정의합니다.
 *
 * 3. MockMvc:
 * - perform()을 통해 요청을 보냅니다.
 * - andExpect()로 응답 상태 및 반환 JSON 값을 검증합니다.
 *
 * 4. ObjectMapper:
 * - CarRequestDTO를 JSON 문자열로 변환하여 요청에 사용할 수 있게 합니다.
 *
 * 5. jsonPath():
 * - 반환된 JSON에서 특정 필드를 검증합니다.
 */
@WebMvcTest(CarController::class)
class CarControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var carService: CarService

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `getCar - 차량을 ID로 조회한다`() {
        // Given
        val carResponse =
            CarResources.CarResponseDTO(
                id = 1L,
                alias = "TestCar",
                type = "CAR",
                plateNumber = "123가1111",
                brandName = "BMW",
                modelName = "M3",
                brandImage = "",
            )
        whenever(carService.getCarById(1L)).thenReturn(carResponse)

        // When & Then
        mockMvc
            .perform(get("/v1/vincenzo/cars/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.alias").value("TestCar"))
            .andExpect(jsonPath("$.brandName").value("BMW"))
            .andExpect(jsonPath("$.modelName").value("M3"))
            .andExpect(jsonPath("$.type").value("CAR"))
    }

    @Test
    fun `createCar - 차량을 생성한다`() {
        // Given
        val request =
            CarResources.CarRequestDTO(
                alias = "TestCar",
                type = "CAR",
                plateNumber = "123가1111",
                brandName = "BMW",
                modelName = "M3",
                brandImage = "",
            )
        val response =
            CarResources.CarResponseDTO(
                id = 1L,
                alias = "TestCar",
                type = "CAR",
                plateNumber = "123가1111",
                brandName = "BMW",
                modelName = "M3",
                brandImage = "",
            )
        whenever(carService.create(any())).thenReturn(response)

        // When & Then
        mockMvc
            .perform(
                post("/v1/vincenzo/cars")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.alias").value("TestCar"))
            .andExpect(jsonPath("$.brandName").value("BMW"))
            .andExpect(jsonPath("$.modelName").value("M3"))
            .andExpect(jsonPath("$.type").value("CAR"))
    }
}
