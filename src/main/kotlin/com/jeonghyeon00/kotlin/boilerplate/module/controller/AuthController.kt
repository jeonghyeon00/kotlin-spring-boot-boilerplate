package com.jeonghyeon00.kotlin.boilerplate.module.controller

import com.jeonghyeon00.kotlin.boilerplate.module.dto.SignInDto
import com.jeonghyeon00.kotlin.boilerplate.module.dto.SignUpDto
import com.jeonghyeon00.kotlin.boilerplate.module.dto.TokenDto
import com.jeonghyeon00.kotlin.boilerplate.module.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpDto: SignUpDto): ResponseEntity<Boolean> {
        return ResponseEntity.ok().body(authService.signUp(signUpDto))
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInDto: SignInDto): TokenDto {
        return authService.signIn(signInDto)
    }
}
