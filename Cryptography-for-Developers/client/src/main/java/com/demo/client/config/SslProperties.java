package com.demo.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

/**
 * {@code SslProperties} contains server SSL properties.
 */
@ConfigurationProperties("server.ssl")
@Getter
@Setter
public class SslProperties {

    private Resource trustStore;

    private String trustStorePassword;

    private String trustStoreType;

    private Resource keyStore;

    private String keyStorePassword;

    private String keyPassword;

    private String keyStoreType;
}
