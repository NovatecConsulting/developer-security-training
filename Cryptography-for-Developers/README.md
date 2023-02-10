# Cryptography for Developers

In this hacking hands-on training, the most common cryptographic concepts and algorithms are presented to teach developers how to securely use cryptography.  

## Cryptography 1x1

### Encryption

#### Symmetric

#### Assymmetric (Private/Public Key)

### Hashing

### Signatures and Certificates

### SSL/TLS

## Setup


### Web Proxy

#### OWASP ZAP

Follow the setup instructions on https://www.zaproxy.org/download/.  

Starting with version 2.8.0, OWASP ZAP includes a _Heads Up Display_. Look into the
corresponding [OWASP ZAP HUD github project](https://github.com/zaproxy/zap-hud) to learn more about this fascinating feature.

### REST API clients

#### Postman

To make calls to REST API of the Juice Shop via a comfortable UI you may use Postman.  
Follow the setup instructions on https://www.postman.com/downloads.

#### Httpie

If you are more used to make calls to REST API of the Juice Shop via command line you may try Httpie.  
Follow the setup instructions on https://httpie.org.

#### Curl

If you are more used to make calls to REST API of the Juice Shop via command line you also may try the classic Curl.  
Follow the setup instructions on https://curl.haxx.se.

### The Labs

The labs are categorized according to the cryptographic types.

* [API01: Broken Object Level Authorization](API01-Broken-Object-Level-Authorization/README.md)
* [API02: Broken User Authentication](API02-Broken-User-Authentication/README.md)
* [API03: Excessive Data Exposure](API03-Excessive-Data-Exposure/README.md)
* [API04: Lack of Resources and Rate Limiting](API04-Lack-of-Resources-and-Rate-Limiting/README.md)
* [API05: Broken Function Level Authorization](API05-Broken-Function-Level-Authorization/README.md)
* [API06: Mass Assignment](API06-Mass-Assignment/README.md)
* [API07: Security Misconfiguration](API07-Security-Misconfiguration/README.md)
* [API08: Injection](API08-Injection/README.md)
* [API09: Improper Assets Management](API09-Improper-Assets-Management/README.md)
* [API10: Insufficient Logging and Monitoring](API10-Insufficient-Logging-and-Monitoring/README.md)
