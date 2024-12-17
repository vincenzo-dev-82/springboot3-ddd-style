package com.vincenzo.product.domain

import com.vincenzo.product.domain.car.Car
import org.apache.logging.log4j.util.Strings

internal class CarTest

internal fun Car.Companion.aDummy() =
    Car(
        alias = "TestCar",
        type = Car.Type.CAR,
        plateNumber = "123가3333",
        brandName = "BMW",
        modelName = "M3",
        brandImage = Strings.EMPTY,
    )
