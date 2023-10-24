package com.load.test.protocol;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import static com.load.test.Properties.PROPERTIES;
import static io.gatling.javaapi.http.HttpDsl.http;

public class HttpProtocols {

    public static HttpProtocolBuilder getHttpProtocol() {
        return http.baseUrl(PROPERTIES.applicationUrl());
    }
}
