package com.example.server.routes

import com.example.server.model.User
import com.example.server.service.UserService
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*

object UserRoutes {
    fun Routing.configure(routing: Routing) {
        post("/register") {
            val user = call.receive<User>()
            val token = UserService.registerUser(user)
            call.respond(mapOf("token" to token))
        }

        post("/login") {
            val user = call.receive<User>()
            val token = UserService.authenticateUser(user.username, user.password)
            if (token!= null) {
                call.respond(mapOf("token" to token))
            } else {
                call.respond(HttpStatusCode.Unauthorized, "Invalid credentials")
            }
        }

        get("/protected") {
            call.authenticate("auth-jwt")
            call.respond("This is a protected endpoint")
        }
    }
}