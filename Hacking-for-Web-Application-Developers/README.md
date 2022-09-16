# Hacking for Web Application Developers (powered by OWASP Juice Shop)

In this hacking hands-on training, the most critical risks in web applications are presented to teach frontend and backend developers how to develop a secure web application.  

After introducing the [Open Web Application Security Project Top 10 2021 (OWASP Top 10 2021)](https://owasp.org/Top10/), a selection of the application security risks listed in the OWASP Top 10 will be described step by step.  

![alt owasp-top-10-2021](images/mapping_owasp_top_10_2021.png "OWASP Top 10 (2021)")

Almost every security risk of the selection has its own folder with certain challenges to solve. In this challenges, the participants of the course have to find various security flaws in 
the [OWASP Juice Shop](https://github.com/bkimminich/juice-shop), which is an intentionally vulnerable web application. 
The descriptions of the challenges include tips to help finding the right way of hacking the application. 

Always read at first only one hint, then try to solve the challenge. If you don't have a clue of going forward, then read the following tip.  

**IMPORTANT:** It is recommended to do the security training in the right order, as the challenges might depend on each other.

## Setup

### OWASP Juice Shop

Follow the setup instructions on https://github.com/juice-shop/juice-shop#setup  
(Installation using _Docker Container_ recommended).

```
docker pull bkimminich/juice-shop:v14.2.1
docker run --rm -p 3000:3000 bkimminich/juice-shop:v14.2.1
```

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

### The Challenges

The challenges are categorized according to the OWASP Top 10 (2021) list.

* [A01: Broken Access Control](A01-Broken-Access-Control/README.md)
* [A02: Cryptographic Failures](A02-Cryptographic-Failures/README.md)
* [A03: Injection](A03-Injection/README.md)
* [A04: Insecure Design](A04-Insecure-Design/README.md)
* [A05: Security Misconfiguration](A05-Security-Misconfiguration/README.md)
* [A06: Vulnerable and Outdated Components](A06-Vulnerable-and-Outdated-Components/README.md)
* [A07: Identification and Authentication Failures](A07-Identification-and-Authentication-Failures/README.md)
* [A08: Software and Data Integrity Failures](A08-Software-and-Data-Integrity-Failures/README.md)
* [A09: Security Logging and Monitoring Failures](A09-Security-Logging-and-Monitoring-Failures/README.md)
* [A10: Server Side Request Forgery](A10-Server-Side-Request-Forgery/README.md)

## Useful links

* [Complete documentation about OWASP Juice Shop](https://bkimminich.gitbooks.io/pwning-owasp-juice-shop/content/)
* [The Page of the OWASP Juice Shop Project in The OWASP Foundation Wiki.](https://www.owasp.org/index.php/OWASP_Juice_Shop)
* [The OWASP Top 10: Description of each application security risk in OWASP](https://www.owasp.org/images/7/72/OWASP_Top_10-2017_%28en%29.pdf.pdf)
* [Postman API Development Environment](https://www.getpostman.com/downloads/)
* [Httpie Http command line client](https://httpie.org/)
* [Curl Http command line client](https://curl.haxx.se/)
* [OWASP ZAP Web Security Proxy & Scanner](https://github.com/zaproxy/zaproxy/wiki/Downloads)