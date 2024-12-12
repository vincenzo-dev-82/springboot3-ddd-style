package com.vincenzo.product.domain.owner

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table

@Entity
@Table(
    indexes = [
        Index(name = "IDX_OWNER_CAR_USER_ID", columnList = "userId"),
    ],
)
data class OwnerCar(
    val userId: Long,
    val carId: Long,
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null
        protected set
}
