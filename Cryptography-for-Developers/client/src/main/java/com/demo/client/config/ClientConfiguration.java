package com.demo.client.config;

import com.demo.client.error.CustomErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.function.Supplier;

/**
 * {@code ClientConfiguration} configures REST template based on scheme type.
 */
@Configuration
@EnableConfigurationProperties({ClientBookProperties.class, SslProperties.class})
public class ClientConfiguration {

    private final ObjectMapper objectMapper;

    private final ClientBookProperties properties;

    private final SslProperties sslProperties;

    @Autowired
    public ClientConfiguration(
            ObjectMapper objectMapper,
            ClientBookProperties properties,
            SslProperties sslProperties) {
        this.objectMapper = objectMapper;
        this.properties = properties;
        this.sslProperties = sslProperties;
    }

    @Bean
    public RestTemplate restTemplate() throws IOException, URISyntaxException,
            GeneralSecurityException {
        RestTemplateBuilder builder = new RestTemplateBuilder();

        return builder
                .basicAuthentication(
                        properties.getUsername(),
                        properties.getPassword()
                )
                .rootUri(clientURI())
                .messageConverters(
                        new MappingJackson2HttpMessageConverter(objectMapper),
                        new StringHttpMessageConverter())
                .requestFactory(requestFactory())
                .errorHandler(new CustomErrorHandler(objectMapper))
                .build();
    }

    private Supplier<ClientHttpRequestFactory> requestFactory() throws
            IOException, GeneralSecurityException {
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient());
        requestFactory.setConnectTimeout(properties.getConnectionTimeout());
        requestFactory.setReadTimeout(properties.getReadTimeout());

        return () -> requestFactory;
    }

    /**
     * Creates a HTTP client which doesn't perform any host name verification
     * in case of TLS connection.
     *
     * {@code SSLConnectionSocketFactory.getDefaultHostnameVerifier()}
     * tries to match the server host name with the cn (common name) in
     * dn (distinguished name) of the server certificate. It's not used as it
     * is very restrictive. Where as {@code NoopHostnameVerifier()} is in the
     * other extreme. It doesn't verify host name at all.
     *
     * @return a HTTP client used for communicating with the server
     */
    private HttpClient httpClient() throws IOException, GeneralSecurityException {
        HttpClientBuilder builder = HttpClients.custom();

        String scheme = properties.getScheme().toUpperCase();
        if (scheme.equals("HTTPS")) {
            // load trust store containing certificates that are trusted
            // and the key store

            // ToDo: write SSLContext

            // ToDo: write SSLConnectionSocketFactory
        } else {
            builder.setSSLHostnameVerifier(new NoopHostnameVerifier());
        }

        return builder.build();
    }

    private KeyStore creatKeyStore(Resource resource, String storeType,
                                   String password) throws IOException, GeneralSecurityException {
        KeyStore ks = KeyStore.getInstance(storeType);
        ks.load(resource.getInputStream(), password.toCharArray());

        return ks;
    }

    private String clientURI() throws URISyntaxException, MalformedURLException {
        return new URI(properties.getScheme(), null, properties.getHost(),
                properties.getPort(), null, null, null).toURL().toString();
    }
}
