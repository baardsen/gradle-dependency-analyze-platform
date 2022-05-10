package com.github.baardsen;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

class JavaHttpRestClient implements RestClient {

    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public Optional<String> fetch(final URL url) {
        try {
            return Optional.ofNullable(client.send(
                HttpRequest.newBuilder(url.toURI()).build(),
                HttpResponse.BodyHandlers.ofString()
            ).body());
        } catch (IOException | InterruptedException | URISyntaxException e) {
            return Optional.empty();
        }
    }

}
