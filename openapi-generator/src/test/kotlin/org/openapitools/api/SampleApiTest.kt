package org.openapitools.api

import org.openapitools.model.SampleGet200Response
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class SampleApiTest {

    private val api: SampleApiController = SampleApiController()

    /**
     * To test SampleApiController.sampleGet
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun sampleGetTest() {
        val response: ResponseEntity<SampleGet200Response> = api.sampleGet()

        // TODO: test validations
    }
}
