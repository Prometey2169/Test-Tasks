
import org.example.http.HttpClientWrapper;
import org.example.pojo.Response;
import org.example.service.JsonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JsonServiceTest {

    @Test
    public void testSendPostRequest() throws Exception {
        HttpClientWrapper httpClientWrapper = Mockito.mock(HttpClientWrapper.class);
        JsonService jsonService = new JsonService(httpClientWrapper);

        String mockResponseJson = "{ \"status\": \"success\", \"data\": { \"timestamp\": \"2025-03-22T18:35:00\", \"details\": { \"processedRecords\": 25, \"errors\": 0 } }, \"message\": \"Request processed successfully\", \"server\": { \"id\": \"server-01\", \"location\": \"us-east-1\" } }";
        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn(mockResponseJson);
        when(httpClientWrapper.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        Response response = jsonService.sendPostRequest("https://example.com/api", "{}");

        assertEquals("success", response.getStatus());
        assertEquals("2025-03-22T18:35:00", response.getData().getTimestamp());
        assertEquals("Request processed successfully", response.getMessage());
    }
}
