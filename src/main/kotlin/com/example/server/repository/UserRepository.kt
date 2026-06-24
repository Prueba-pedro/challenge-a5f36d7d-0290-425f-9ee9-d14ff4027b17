package com.example.server.repository

import com.example.server.model.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object UserRepository {
    fun createUser(user: User): Int {
        return transaction {
            UserTable.insert {
                it[username] = user.username
                it[password] = user.password
            }.resultedValues?.get(0)?.value as Int
        }
    }

    fun getUserByUsername(username: String): User? {
        return transaction {
            UserTable.select { UserTable.username eq username }.firstOrNull()?.let {
                User(
                    id = it[UserTable.id],
                    username = it[UserTable.username],
                    password = it[UserTable.password]
                )
            }
        }
    }
}

object UserTable : Table("users") {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 50)
    val password = varchar("password", 100)
    override val primaryKey = PrimaryKey(id, name = "PK_User")
}