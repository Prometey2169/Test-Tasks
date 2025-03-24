import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.http.HttpClientWrapper;
import org.example.pojo.*;
import org.example.service.JsonService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JsonServiceTest {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    @Test
    public void testSendPostRequest() {
        // 1. Подготовка тестовых данных
        HttpClientWrapper httpClientWrapper = Mockito.mock(HttpClientWrapper.class);
        JsonService jsonService = new JsonService(httpClientWrapper);

        Root testRoot = createTestRoot();
        String expectedRequestJson = jsonService.serializeToJson(testRoot);

        // 2. Настройка моков
        String mockResponseJson = createMockResponseJson();
        HttpResponse<String> mockResponse = createMockHttpResponse(mockResponseJson);

        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        when(httpClientWrapper.send(requestCaptor.capture(), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);

        // 3. Вызов тестируемого метода
        Response response = jsonService.sendPostRequest("https://example.com/api", expectedRequestJson);

        // 4. Вывод информации в консоль
        System.out.println("\nПолученные значения статуса и времени: " +
                "status=" + response.getStatus() +
                ", timestamp=" + response.getData().getTimestamp());

        // 5. Проверки
        verifyResponseFields(response);
        verifySentRequest(requestCaptor.getValue(), expectedRequestJson);
    }

    // Остальные методы остаются без изменений
    private Root createTestRoot() {
        Root testRoot = new Root();
        testRoot.setUsers(List.of(
                new User(1, "User1", "user1@example.com", true,
                        new AdditionalInfo("Developer", "Engineering")),
                new User(2, "User2", "user2@example.com", false,
                        new AdditionalInfo("Tester", "QA")),
                new User(3, "User3", "user3@example.com", true,
                        new AdditionalInfo("Manager", "Product"))
        ));
        testRoot.setSettings(new Settings("dark", true, "en-US"));
        testRoot.setMetadata(new Metadata("2025-03-22T18:31:00", "1.0.0"));
        return testRoot;
    }

    private String createMockResponseJson() {
        return """
                {
                    "status": "success",
                    "data": {
                        "timestamp": "2025-03-22T18:35:00",
                        "details": {
                            "processedRecords": 25,
                            "errors": 0
                        }
                    },
                    "message": "Request processed successfully",
                    "server": {
                        "id": "server-01",
                        "location": "us-east-1"
                    }
                }
                """;
    }

    private HttpResponse createMockHttpResponse(String responseBody) {
        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn(responseBody);
        when(mockResponse.statusCode()).thenReturn(200);
        return mockResponse;
    }

    private void verifyResponseFields(Response response) {
        assertEquals("success", response.getStatus());
        assertEquals("2025-03-22T18:35:00", response.getData().getTimestamp());
        assertEquals("Request processed successfully", response.getMessage());
    }

    private void verifySentRequest(HttpRequest sentRequest, String expectedJson) {
        assertTrue(sentRequest.headers().firstValue("Content-Type").isPresent());
        assertEquals("application/json", sentRequest.headers().firstValue("Content-Type").get());
        assertEquals("POST", sentRequest.method());
        assertEquals("https://example.com/api", sentRequest.uri().toString());
    }
}