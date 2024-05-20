package com.jeonghyeon00.kotlin.boilerplate.module.entity

import com.jeonghyeon00.kotlin.boilerplate.module.constants.Authority
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    val userId: String,
    val password: String,
    val userName: String,
    @Enumerated(EnumType.STRING)
    val authority: Authority
)
