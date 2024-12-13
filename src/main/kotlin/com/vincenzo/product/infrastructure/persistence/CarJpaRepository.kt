package com.vincenzo.product.infrastructure.persistence

import com.vincenzo.product.domain.car.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarJpaRepository : JpaRepository<Car, Long>
