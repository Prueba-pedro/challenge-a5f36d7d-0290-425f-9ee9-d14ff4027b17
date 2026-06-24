package com.example.server.service

import com.example.server.model.User
import com.example.server.repository.UserRepository
import com.example.server.util.JwtValidator

object UserService {
    suspend fun registerUser(user: User): String {
        val userId = UserRepository.createUser(user)
        return JwtValidator.generateToken(userId, user.username)
    }

    suspend fun authenticateUser(username: String, password: String): String? {
        val user = UserRepository.getUserByUsername(username)
        if (user!= null && user.password == password) {
            return JwtValidator.generateToken(user.id!!, user.username)
        }
        return null
    }
}