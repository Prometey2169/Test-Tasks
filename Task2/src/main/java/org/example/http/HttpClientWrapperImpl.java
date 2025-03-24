package org.example.http;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientWrapperImpl implements HttpClientWrapper {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler) throws Exception {
        return httpClient.send(request, responseBodyHandler);
    }
}
