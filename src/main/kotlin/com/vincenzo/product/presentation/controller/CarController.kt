package com.vincenzo.product.presentation.controller

import com.vincenzo.product.application.dto.CarResources
import com.vincenzo.product.application.service.CarService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/vincenzo/cars")
class CarController(
    private val carService: CarService,
) {
    @GetMapping("/{id}")
    fun getCar(
        @PathVariable id: Long,
    ): ResponseEntity<CarResources.CarResponseDTO> {
        val car = carService.getCarById(id)
        return ResponseEntity.ok(car)
    }

    @PostMapping
    fun createCar(
        @RequestBody request: CarResources.CarRequestDTO,
    ): ResponseEntity<CarResources.CarResponseDTO> {
        val savedCar = carService.create(request)
        return ResponseEntity.ok(savedCar)
    }
}
