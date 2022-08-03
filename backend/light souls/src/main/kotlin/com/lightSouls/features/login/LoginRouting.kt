package com.lightSouls.features.login

import com.lightSouls.cache.InMemoryCache
import com.lightSouls.cache.TokenCache
import com.lightSouls.features.register.RegisterReceiveRemote
import com.lightSouls.plugins.CallTest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.configureLoginRouting() {

    routing {
        post("/login") {
            val receive = call.receive<LoginReceiveRemote>()
            val first = InMemoryCache.userList.firstOrNull { it.login == receive.login }

            if (first == null){
                call.respond(HttpStatusCode.BadRequest, "User not found")
            } else{
                if (first.password == receive.password){
                    val token = UUID.randomUUID().toString()
                    InMemoryCache.tokenList.add(TokenCache(login = receive.login, token = token))
                    call.respond(LoginResponseRemote(token = token))
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Invalid password")
                }
            }
        }
    }
}