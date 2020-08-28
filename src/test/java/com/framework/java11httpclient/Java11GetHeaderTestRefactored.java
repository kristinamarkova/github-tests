package com.framework.java11httpclient;

import static java.net.http.HttpClient.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Java11GetHeaderTestRefactored {

    private static final String BASE_URL = "https://api.github.com/";

    static HttpClient httpClient = newBuilder().build();
    static HttpResponse<Void> response;

    @BeforeAll
    static void sendGetToBaseEndpoint() throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                //.GET() // Commented because GET is the default method anyway
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        // Act - sent request
        response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    }

    @Test
    void getReturns200() {

        int actualCode = response.statusCode();
        assertEquals(200, actualCode);

    }

    @ParameterizedTest
    @CsvSource({
            "X-Ratelimit-Limit,60",
            "content-type,application/json; charset=utf-8",
            "server,GitHub.com",
            "x-frame-options,deny"
    })
    void parametrizedTestForHeaders(String header,String expectedValue) {

        String contentType = response.headers().firstValue(header).get();
        assertEquals(expectedValue, contentType);
    }

}
