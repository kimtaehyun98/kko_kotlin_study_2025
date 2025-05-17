package com.example.server.service

import com.example.server.repository.ApiRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class ApiServiceTest {

    @MockK
    lateinit var apiRepository: ApiRepository

    @InjectMockKs
    lateinit var apiService: ApiService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun getBirthDate() {
        // given
        val defaultDate = "11-07"
        every { apiRepository.getBirthDateByName(any()) } returns defaultDate

        // when & then
        assertEquals(apiService.getBirthDateByName("hyun"), defaultDate)
    }
}