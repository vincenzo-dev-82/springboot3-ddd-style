package com.vincenzo.product.domain.owner

import com.vincenzo.product.shared.Audit
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicUpdate

@DynamicUpdate
@Entity
@Table(name = "owner")
data class Owner(
    val name: String,
) : Audit() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set
}
