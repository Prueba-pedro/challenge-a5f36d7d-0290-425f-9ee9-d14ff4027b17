# Implementación de un servidor HTTP seguro con Ktor

Necesitamos un servidor HTTP que maneje solicitudes de clientes para un servicio de gestión de usuarios. El servidor debe autenticar las solicitudes mediante JWT y persistir los datos de los usuarios en una base de datos utilizando Exposed ORM. Los actores involucrados son el 'cliente móvil', el'servidor de autenticación' y la 'base de datos de usuarios'. El servidor debe manejar un mínimo de 100 solicitudes por segundo con un tiempo de respuesta promedio de 200ms. En caso de fallo del servidor de autenticación, el servidor debe continuar operando sin autenticación durante un máximo de 5 minutos.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | servidor-http-con-ktor |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Gradle 8+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `gradle build` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del entorno

**Objetivo:** Tener un entorno de desarrollo listo para implementar el servidor HTTP.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Configurar un proyecto Ktor básico.
- Asegurar que el proyecto compile y ejecute sin errores.

**Entregable:** Proyecto Ktor básico ejecutable.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las dependencias necesarias para Ktor, Exposed ORM y JWT.

</details>

### Fase 2: Implementación del endpoint de registro de usuario

**Objetivo:** Crear un endpoint que permita a los usuarios registrarse en el sistema.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementar un endpoint POST `/register` que reciba los datos del usuario y los persista en la base de datos.
- El endpoint debe validar los datos del usuario y manejar errores de validación.
- El endpoint debe devolver un token JWT al usuario registrado.

**Entregable:** Endpoint de registro de usuario funcional.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo validar los datos del usuario antes de persistirlos.
- Piensa en cómo generar y devolver un token JWT.

</details>

### Fase 3: Implementación del endpoint de autenticación

**Objetivo:** Crear un endpoint que permita a los usuarios autenticarse en el sistema.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Implementar un endpoint POST `/login` que reciba las credenciales del usuario y devuelva un token JWT si las credenciales son válidas.
- El endpoint debe manejar errores de autenticación.

**Entregable:** Endpoint de autenticación funcional.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo verificar las credenciales del usuario.
- Piensa en cómo manejar errores de autenticación.

</details>

### Fase 4: Manejo de errores y recuperación

**Objetivo:** Implementar mecanismos para manejar errores y recuperarse de fallos del servidor de autenticación.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Implementar un mecanismo para continuar operando sin autenticación durante un máximo de 5 minutos en caso de fallo del servidor de autenticación.
- El servidor debe manejar un mínimo de 100 solicitudes por segundo con un tiempo de respuesta promedio de 200ms.

**Entregable:** Mecanismo de manejo de errores y recuperación funcional.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo implementar un mecanismo de caché para los tokens JWT.
- Piensa en cómo manejar la recuperación del servidor de autenticación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Ktor y para qué se utiliza en este contexto?
- **paraQueSirve**: ¿Para qué sirve Exposed ORM en la persistencia de datos?
- **comoSeUsa**: ¿Cómo se utiliza JWT para la autenticación de usuarios?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar un servidor HTTP con Ktor y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de un mecanismo de recuperación en caso de fallo del servidor de autenticación?

## Criterios de Evaluacion

- Configuración correcta del proyecto Ktor.
- Implementación funcional del endpoint de registro de usuario.
- Implementación funcional del endpoint de autenticación.
- Mecanismo de manejo de errores y recuperación funcional.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
