package com.example.server.service

import com.example.server.repository.ApiRepository
import org.springframework.stereotype.Service

@Service
class ApiService(
    private val apiRepository: ApiRepository
) {
    fun getNameWithHelloStr(name: String): String {
        return "Hello $name!"
    }

    fun getBirthDateByName(birthDate: String): String {
        return apiRepository.getBirthDateByName(birthDate)
    }
}