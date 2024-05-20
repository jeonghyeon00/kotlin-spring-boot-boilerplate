package com.jeonghyeon00.kotlin.boilerplate.module.service

import com.jeonghyeon00.kotlin.boilerplate.module.constants.Authority
import com.jeonghyeon00.kotlin.boilerplate.module.dto.SignInDto
import com.jeonghyeon00.kotlin.boilerplate.module.dto.SignUpDto
import com.jeonghyeon00.kotlin.boilerplate.module.dto.TokenDto
import com.jeonghyeon00.kotlin.boilerplate.module.entity.User
import com.jeonghyeon00.kotlin.boilerplate.module.repository.UserRepository
import com.jeonghyeon00.kotlin.boilerplate.module.security.JwtTokenProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val tokenProvider: JwtTokenProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun signUp(signUpDto: SignUpDto): Boolean {
        signUpDto.apply {
            userRepository.save(
                User(
                    userId,
                    passwordEncoder.encode(password),
                    userName,
                    Authority.USER
                )
            )
        }
        return true
    }

    fun signIn(signInDto: SignInDto): TokenDto {
        signInDto.apply {
            val credential = UsernamePasswordAuthenticationToken(userId, password)
            val authentication = authenticationManagerBuilder.`object`.authenticate(credential)
            val token = tokenProvider.createToken(authentication)
            return TokenDto(token)
        }
    }
}
