package com.example.server.repository

import org.springframework.stereotype.Repository

@Repository
class ApiRepository {

    private val birthDateMap = mapOf("hyun" to "11-07")

    fun getBirthDateByName(name: String): String {
        return birthDateMap.getValue(name)
    }

}