package org.example.http;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface HttpClientWrapper {
    <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler);
}
