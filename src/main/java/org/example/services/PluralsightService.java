package org.example.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PluralsightService {
    private static final String URL_ENDPOINT = "https://app.pluralsight.com/profile/author/kevin-jones";
    private static final String URL_ENDPOINT2 = "https://app.pluralsight.com/profile/data/author/%s/all-content";
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();
    public String getCoursesForAuthor(String authorId) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(java.net.URI.create(String.format(URL_ENDPOINT2, authorId)))
                .build();
//        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(URL_ENDPOINT2.formatted(authorId))).GET().build();
/*        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();*/
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString())
                .body();
    }
}
