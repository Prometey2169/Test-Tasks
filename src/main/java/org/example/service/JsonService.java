package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.http.HttpClientWrapper;
import org.example.pojo.Response;
import org.example.pojo.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class JsonService {
    private final HttpClientWrapper httpClientWrapper;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonService.class);

    public JsonService(HttpClientWrapper httpClientWrapper) {
        this.httpClientWrapper = httpClientWrapper;
    }

    public String serializeToJson(Root root) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Response sendPostRequest(String url, String json) {
        logger.info("Sending POST request to URL: {}", url);
        logger.info("Request JSON: {}", json);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = httpClientWrapper.send(request, HttpResponse.BodyHandlers.ofString());

        // Проверка статус-кода
        if (response.statusCode() != 200) {
            throw new RuntimeException("HTTP request failed with status code: " + response.statusCode());
        }

        logger.info("Received response from server. Status code: {}", response.statusCode());
        logger.info("Response JSON: {}", response.body());
        try {
            return objectMapper.readValue(response.body(), Response.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}