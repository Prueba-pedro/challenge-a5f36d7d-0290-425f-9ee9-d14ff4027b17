package com.example.server.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.auth0.jwt.interfaces.JWTVerifier

object JwtValidator {
    private const val SECRET = "secret"
    private val algorithm = Algorithm.HMAC256(SECRET)
    val verifier: JWTVerifier = JWT.require(algorithm).build()

    fun generateToken(userId: Int, username: String): String {
        return JWT.create()
           .withClaim("userId", userId)
           .withClaim("username", username)
           .sign(algorithm)
    }
}