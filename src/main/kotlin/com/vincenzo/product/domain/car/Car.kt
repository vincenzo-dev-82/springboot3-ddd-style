package com.vincenzo.product.domain.car

import com.vincenzo.product.shared.Audit
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicUpdate

@DynamicUpdate
@Entity
@Table(
    name = "car",
    indexes = [
        Index(name = "IDX_PLATE_NUMBER", columnList = "plateNumber"),
    ],
)
data class Car(
    @Column(nullable = true)
    val alias: String,
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10)")
    var type: Type = Type.CAR,
    @Column(length = 50)
    val plateNumber: String,
    @Column(length = 100)
    var brandName: String,
    @Column(length = 100)
    var modelName: String,
    @Column(length = 500)
    var brandImage: String? = null,
) : Audit() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    enum class Type {
        CAR,
        TRUCK,
        BIKE,
    }
}
