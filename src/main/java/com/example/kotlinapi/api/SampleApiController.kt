package com.example.kotlinapi.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.openapitools.model.SampleGet200Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class SampleApiController() {

    @Operation(
        summary = "Returns a greeting message",
        operationId = "sampleGet",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "A JSON object containing a greeting message", content = [Content(schema = Schema(implementation = SampleGet200Response::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/sample"],
        produces = ["application/json"]
    )
    fun sampleGet(): ResponseEntity<SampleGet200Response> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
