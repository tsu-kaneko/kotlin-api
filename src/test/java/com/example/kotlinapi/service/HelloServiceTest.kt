package com.example.kotlinapi.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HelloServiceTest @Autowired constructor(
    private val helloService: HelloService
) {

    // プロパティインジェクション
    // @Autowired
    // lateinit var sampleService: SampleService

    @Test
    fun `test`() {
        helloService.basic()
        helloService.lambda()
        helloService.lambda2()
        helloService.elvis()
        helloService.structuralEqual()
    }
}