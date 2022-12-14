package com.lightSouls

import com.lightSouls.features.login.configureLoginRouting
import com.lightSouls.features.register.configureRegisterRouting
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import com.lightSouls.plugins.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        Serialization()
    }.start(wait = true)
}
