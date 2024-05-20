package com.jeonghyeon00.kotlin.boilerplate.module.repository

import com.jeonghyeon00.kotlin.boilerplate.module.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String>
