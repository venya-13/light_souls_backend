package com.lightSouls.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.Serialization() {
    install(ContentNegotiation) {
        json()
    }
}