package com.github.baardsen;

import java.net.URL;
import java.util.Optional;

public interface RestClient {

    Optional<String> fetch(URL url);

    public static RestClient create() {
        if (isOkHttpPresent()) {
            return new OkHttpRestClient();
        }
        return new JavaHttpRestClient();
    }

    private static boolean isOkHttpPresent() {
        try {
            Class.forName(
                "com.squareup.okhttp3.OkHttpClient",
                false,
                RestClient.class.getClassLoader()
            );
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            return false;
        }
    }
}
