package com.vincenzo.product.domain

enum class FuelType(
    val fuelName: String,
    val description: String,
) {
    GASOLINE("Gasoline", "휘발유"),
    DIESEL("Diesel", "경유"),
    HYDROGEN("Hydrogen", "수소"),
    ELECTRIC("Electric", "EV"),
    ;

    companion object {
        fun findBy(fuelName: String): FuelType? = entries.find { it.fuelName == fuelName }
    }
}
