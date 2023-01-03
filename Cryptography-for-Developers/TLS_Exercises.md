Spring TLS Example
==================================
This is an example of using TLS (Transport Layer Security) with Spring Boot.
In this example, TLS is enabled in both server and client. Basic Access
Authorization is also enabled on the server side.

### Introduction to TLS
Transport Layer Security (TLS) is a protocol that provides privacy and
data integrity between two communicating applications, e.g., server and client.
It's replacement for Secure Sockets Layer (SSL).

TLS provides a secured communication by encrypting the data transmitted
using symmetric cryptography.

> Setup
* run `mvn cleans install` for client & server
* import the Postman Collection
* start the server & client
* send a request to create a book

### Build Server
To build the JAR, execute the following command in the server directory:

```
mvn clean install
```

This should build the following Spring Boot jars:

- The server jar located in `server/target`
  folder.

### Run Server
To start the server, run the executable jar from the command:

```
java -jar server/target/server-0.0.1-SNAPSHOT.jar
```

### Build Client
To build the JAR, execute the following command in the server directory:

```
mvn clean install
```

This should build the following Spring Boot jars:

- The client jar located in `client/target`
  folder.

### Run Client
Similarly, run the executable jar from the command to start the client:

```
java -jar client/target/client-0.0.1-SNAPSHOT.jar
```
<br/>

> Exercise 1: One-Way TLS

### Key and Certificate Creation

Java **keytool** is a key and certificate management utility. It allows users to
do the following:

1. Create and manage their own **public/private key pairs** and **certificates**.
   A **certificate** contains the **public key** (and some other information)
   used for authentication.

1. Allows to cache private keys and certificates in a file called **keystore**.
   A keystore may contain any certificate required to complete a chain of trust.
   Each certificate is associated with a unique **alias**. The private keys are
   protected with a **password**.

A keytool is part of the standard java distribution. For example in In MAC OS,
it is located under:

`/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/bin`

The `generate-key.ssh` shell script under `script` folder can be executed to
create keys and certificates. 
You have to adjust it in order to to make it do the following:

1. Generate a **RSA 2048 public/private key pairs** for the server and store
   in the the server **keystore** of type `PKCS12`. The server keystore,
   `server-keystore.p12`, is created in the `server/main/resources/config` folder.

1. Generate a **RSA 2048 public/private key pairs** for the client and store
   in the client **keystore** of type `PKCS12`. The client keystore,
   `client-keystore.p12` is created in the `client/main/resources/config` folder.

1. Export the server's **certificate**. A file named `server-public.cer` is
   created in the `script` folder.

1. Import the server certificate, `server-public.cer` in the client's
   keystore, `client-keystore.p12`.

### Configure TLS (SSL) in Spring Boot Server

TLS is configured in the Spring Boot server by the `server.ssl.*` properties
in the `application.yml`. Here is how the example server is configured in the server
`application.yml` file:

```yaml
server:
  port: 8443
  ssl:
    key-store-type: PKCS12
    key-store: classpath:config/server-keystore.p12
    key-store-password: server
    key-alias: server
```

- `server.port` specifies the SSL port of the server. Spring Boot does not
  support the configuration of both an HTTP connector and an HTTPS connector
  via the `application.yml`.

- `server.ssl.key-store-type` specifies the **type** of Java **keystore**. In this
  example, the keystore is of `PKCS12` type. The other option is `JKS`, a proprietary
  Java specific format. Oracle recommends `PKCS12` format.

- `server.ssl.key-store` specifies the **location** of the **keystore**. In
  this example, the file `server-keystore.p12` (server keystore) in located in the
  `resources` folder.

- `server.ssl.key-store-password` is the **password** used during the
  creation of the **keystore** to protect the **private key** by using
  the **keytool**.

- `server.ssl.key-alias` is the **alias** used during the creation of the
  **keystore** using the **keytool** utility.

### Enable TLS in Spring Boot Client

#### Configure a SSL Context with Trusted Store

Here is an example of creating a secured `SSLContext` which is used
to validate the identity of the HTTPS server against a list of trusted
certificates stored in the **trust-store**.

```java
private HttpClient httpClient() throws IOException, GeneralSecurityException {
    SSLContext sslcontext =
        SSLContexts.custom()
            .loadTrustMaterial(
                creatKeyStore(sslProperties.getTrustStore(),
                    sslProperties.getTrustStoreType(),
                    sslProperties.getTrustStorePassword()),
                null)
            .build();
    ...        
}            
```

The client rejects any connection during the TLS handshake if the HTTPS
server tries to authenticate with a certificate not present in the trusted store.

Configuring `keystore` in SSL context is **optional**.

```java
private HttpClient httpClient() throws IOException, GeneralSecurityException {
    SSLContext sslcontext =
        SSLContexts.custom()
            ...
            .loadKeyMaterial(
                creatKeyStore(sslProperties.getKeyStore(),
                    sslProperties.getKeyStoreType(),
                    sslProperties.getKeyStorePassword()),
                sslProperties.getKeyPassword().toCharArray())
            .build();
    ...        
}           
```

Here is the code for method `creatKeyStore`:

 ```java
    private KeyStore creatKeyStore(Resource resource, String storeType,
            String password) throws IOException, GeneralSecurityException {
        KeyStore ks = KeyStore.getInstance(storeType);
        ks.load(resource.getInputStream(), password.toCharArray());

        return ks;
    }
```

#### Create HttpClient

Once the SSL context is created, create the connection factory with the
newly created SSL context and the `NoopHostnameVerifier`.

```java
private HttpClient httpClient() throws IOException, GeneralSecurityException {
    ... 
    SSLConnectionSocketFactory socketFactory =
        new SSLConnectionSocketFactory(sslcontext, new NoopHostnameVerifier());
            
    HttpClientBuilder builder = HttpClients.custom();           
    builder.setSSLSocketFactory(socketFactory);

    return builder.build();
}
 ```     

The `SSLConnectionSocketFactory.getDefaultHostnameVerifier()` is not used
since it tries to match the server host name with the CN (common name) RDN
in the DN (distinguished name) provided in the server certificate. It's not used
as it's very restrictive. Where as `NoopHostnameVerifier()` doesn't verify host
name at all.

<br/>

> Exercise 2: Two-Way (Mutual) TLS

The `generate-key.ssh` shell script under `script` folder can be executed to
create keys and certificates.
You have to adjust it in order to to make it do the following:

1. Generate a **RSA 2048 public/private key pairs** for the server and store
   in the the server **keystore** of type `PKCS12`. The server keystore,
   `server-keystore.p12`, is created in the `server/main/resources/config` folder.

1. Generate a **RSA 2048 public/private key pairs** for the client and store
   in the client **keystore** of type `PKCS12`. The client keystore,
   `client-keystore.p12` is created in the `client/main/resources/config` folder.

1. Export the server's **certificate**. A file named `server-public.cer` is
   created in the `script` folder.

1. Export the client's **certificate**, A file named `client-public.cer` is
   created in the `script` folder.

1. Import the server certificate, `server-public.cer` in the client's
   keystore, `client-keystore.p12`.

1. Import the client certificate, `server-public.cer` in the client's
   keystore, `server-keystore.p12`(optional for TLS).