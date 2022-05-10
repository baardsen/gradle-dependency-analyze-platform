package com.github.baardsen;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import okhttp3.OkHttpClient;
import okhttp3.Request;

class OkHttpRestClient implements RestClient {

    private final OkHttpClient client = new OkHttpClient();

    @Override
    public Optional<String> fetch(final URL url) {
        var request = new Request.Builder()
            .url(url)
            .build();

        try (var response = client.newCall(request).execute()) {
            return Optional.ofNullable(response.body())
                .map(responseBody -> {
                    try {
                        return responseBody.string();
                    } catch (IOException e) {
                        return null;
                    }
                });
        } catch (IOException e) {
            return Optional.empty();
        }
    }

}
