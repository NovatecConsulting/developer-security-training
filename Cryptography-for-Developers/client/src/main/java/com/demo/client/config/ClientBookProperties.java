package com.demo.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * {@code ClientBookProperties} contains HTTP client properties related to Book REST API
 */
@ConfigurationProperties("client.book")
@Getter
@Setter
public class ClientBookProperties {

    private String scheme;

    private String host;

    private int port = -1;

    private int connectionTimeout = 1000;

    private int readTimeout = 1000;

    private String username;

    private String password;
}
