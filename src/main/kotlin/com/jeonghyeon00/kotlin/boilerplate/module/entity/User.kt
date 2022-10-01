package com.jeonghyeon00.kotlin.boilerplate.module.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Id
    val userId: String,
    val password: String,
    val userName: String
)
