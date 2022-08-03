package com.lightSouls.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable

@Serializable
data class CallTest(
    val text: String
)

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("HI!")
        }
    }
}
