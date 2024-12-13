package com.vincenzo.product.domain

import com.vincenzo.product.domain.car.Car

internal class CarTest

internal fun Car.Companion.aDummy() =
    Car(
        alias = "My Honey",
        type = Car.Type.CAR,
        plateNumber = "123가1234",
        brandName = "BMW",
        modelName = "M3",
        brandImage = "/brands/bmw.png",
    )
