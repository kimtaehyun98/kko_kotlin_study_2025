package com.example.server.controller

import com.example.server.service.ApiService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(
    private val apiService: ApiService,
) {

    @GetMapping("/hello")
    fun helloGet(): String {
        return "Hello World!"
    }

    @PostMapping("/hello")
    fun helloPost(): String {
        return "Hello World!"
    }

    @GetMapping("/test")
    fun getNameWithHelloStr(@RequestParam("name") name: String?): ResponseEntity<String> {
        if (name == null) {
            throw NullPointerException()
        }

        return ResponseEntity.ok(apiService.getNameWithHelloStr(name))
    }
}