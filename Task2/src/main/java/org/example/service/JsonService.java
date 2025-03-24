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
    private static final Logger logger = LoggerFactory.getLogger(JsonService.class); // Логгер

    public JsonService(HttpClientWrapper httpClientWrapper) {
        this.httpClientWrapper = httpClientWrapper;
    }

    public String serializeToJson(Root root) throws Exception {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
    }

    public Response sendPostRequest(String url, String json) throws Exception {
        // Логируем отправляемый JSON
        logger.info("Sending POST request to URL: {}", url);
        logger.info("Request JSON: {}", json);

        // Создаем HTTP-запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Отправляем запрос и получаем ответ
        HttpResponse<String> response = httpClientWrapper.send(request, HttpResponse.BodyHandlers.ofString());

        // Логируем получаемый JSON
        logger.info("Received response from server:");
        logger.info("Response JSON: {}", response.body());

        // Десериализуем ответ
        return objectMapper.readValue(response.body(), Response.class);
    }
}