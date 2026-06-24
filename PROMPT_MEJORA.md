# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto corregido y listo para compilar.

---

```
Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación o descripciones sin código, genera los archivos
correspondientes sin aplicar análisis de compilación
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
// === ARCHIVO: build.gradle.kts ===
plugins {
    kotlin("jvm") version "1.8.0"
    id("io.ktor.plugin") version "2.3.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.0")
    implementation("io.ktor:ktor-server-netty:2.3.0")
    implementation("org.jetbrains.exposed:exposed-core:0.38.2")
    implementation("org.jetbrains.exposed:exposed-dao:0.38.2")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.38.2")
    implementation("com.auth0:java-jwt:3.18.1")
}

// === ARCHIVO: src/main/kotlin/com/example/server/Application.kt ===
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

// === ARCHIVO: src/main/kotlin/com/example/server/config/SecurityConfig.kt ===
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

// === ARCHIVO: src/main/kotlin/com/example/server/model/User.kt ===
package com.example.server.model

data class User(
    val id: Int? = null,
    val username: String,
    val password: String
)

// === ARCHIVO: src/main/kotlin/com/example/server/repository/UserRepository.kt ===
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

// === ARCHIVO: src/main/kotlin/com/example/server/service/UserService.kt ===
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

// === ARCHIVO: src/main/kotlin/com/example/server/routes/UserRoutes.kt ===
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

// === ARCHIVO: src/main/kotlin/com/example/server/util/JwtValidator.kt ===
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

// === ARCHIVO: src/main/resources/application.conf ===
ktor {
    deployment {
        port = 8080
    }
    application {
        modules = [ com.example.server.Application.module ]
    }
}

```
