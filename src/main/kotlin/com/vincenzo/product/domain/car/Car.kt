package com.vincenzo.product.domain.car

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicUpdate

@DynamicUpdate
@Entity
@Table(name = "car")
data class Car(
    @Column(nullable = true)
    val alias: String,
    @Column(nullable = false)
    val brand: String,
    @Column(nullable = false)
    val model: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set
}
