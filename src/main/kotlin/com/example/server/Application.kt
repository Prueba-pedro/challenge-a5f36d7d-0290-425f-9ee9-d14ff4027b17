package com.example.server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import com.example.server.config.SecurityConfig
import com.example.server.routes.UserRoutes

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            gson {}
        }
        install(StatusPages) {
            exception<Throwable> {
                call.respond(it)
            }
        }
        SecurityConfig.configure(this)
        routing {
            UserRoutes.configure(this)
        }
    }.start(wait = true)
}