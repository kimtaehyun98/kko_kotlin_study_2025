package com.example.server.controller

import com.example.server.service.ApiService
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test

@WebMvcTest(ApiController::class) // @SpringBootTest와의 차이점 : 전체 컨텍스트(빈) 로드.
class ApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var apiService: ApiService

    @Test
    fun hasName() {
        // given
        val name = "hyun"
        val expected = "Hello $name!"

        // when
        `when`(apiService.getNameWithHelloStr(name))
            .thenReturn(expected)

        // then
        mockMvc.perform(
            get("/test")
                .queryParam("name", name)
        )
            .andExpect(status().isOk)
            .andExpect(content().string(expected))
    }

    @Test
    fun hasNullName() {
        // given
        val name = null

        // then
        mockMvc.perform(
            get("/test")
        )
            .andExpect(status().isBadRequest)
            .andExpect(content().string("NPE"))

    }

}