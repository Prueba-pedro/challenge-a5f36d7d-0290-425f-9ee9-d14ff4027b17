package com.example.server.config

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.locations.KtorExperimentalLocationsAPI

object SecurityConfig {
    fun Application.configure(app: Application) {
        app.install(Authentication) {
            jwt("auth-jwt") {
                realm = "ktor"
                verifier(JwtValidator().verifier)
                validate { JWTPrincipal(it.payload) }
            }
        }
    }
}