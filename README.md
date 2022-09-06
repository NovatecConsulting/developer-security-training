# Security Training for Developers

In this security training, the most critical risks in software applications are presented to teach developers how to develop a secure web application.  
After introducing the Open Web Application Security Project Top 10 (OWASP Top 10), a selection of the application security risks listed in the OWASP Top 10 will be described step by step. Each security risk of the selection has its own folder with certain challenges to solve. 
In these challenges, the participants of the course have to find various security flaws in the [OWASP Juice Shop](https://github.com/bkimminich/juice-shop), which is an intentionally vulnerable web application.

## Learning targets
1. Understand basic security terminology
2. Understand importance of security
3. OWASP
   1. What is it?
   2. What does OWASP offer? (Projects)
   3. Highlight one of the most popular and important project: OWASP Top 10
4. Insights on a selected set of static and dynamic application security testing tools
5. Finding and exploiting vulnerabilities to understand the impact they could cause
6. Fixing/avoiding specific security issues

### Table of contents
1. [Open Web Application Security Project (OWASP)](https://owasp.org/)
2. [OWASP Juice Shop](https://github.com/bkimminich/juice-shop) 
3. Security Tools
4. [Hacking for Web Application Developers](Hacking-for-Web-Application-Developers/README.md)
   * [A01: Broken Access Control](Hacking-for-Web-Application-Developers/A01-Broken-Access-Control/README.md)
   * [A02: Cryptographic Failures](Hacking-for-Web-Application-Developers/A02-Cryptographic-Failures/README.md)
   * [A03: Injection](Hacking-for-Web-Application-Developers/A03-Injection/README.md)
   * [A04: Insecure Design](Hacking-for-Web-Application-Developers/A04-Insecure-Design/README.md)
   * [A05: Security Misconfiguration](Hacking-for-Web-Application-Developers/A05-Security-Misconfiguration/README.md)
   * [A06: Vulnerable and Outdated Components](Hacking-for-Web-Application-Developers/A06-Vulnerable-and-Outdated-Components/README.md)
   * [A07: Identification and Authentication Failures](Hacking-for-Web-Application-Developers/A07-Identification-and-Authentication-Failures/README.md)
   * [A08: Software and Data Integrity Failures](Hacking-for-Web-Application-Developers/A08-Software-and-Data-Integrity-Failures/README.md)
   * [A09: Security Logging and Monitoring Failures](Hacking-for-Web-Application-Developers/A09-Security-Logging-and-Monitoring-Failures/README.md)
   * [A10: Server Side Request Forgery](Hacking-for-Web-Application-Developers/A10-Server-Side-Request-Forgery/README.md)
4. [Hacking for API Developers](Hacking-for-API-Developers/README.md)   
   * [API01: Broken Object Level Authorization](Hacking-for-API-Developers/API01-Broken-Object-Level-Authorization/README.md)
   * [API02: Broken User Authentication](Hacking-for-API-Developers/API02-Broken-User-Authentication/README.md)
   * [API03: Excessive Data Exposure](Hacking-for-API-Developers/API03-Excessive-Data-Exposure/README.md)
   * [API04: Lack of Resources and Rate Limiting](Hacking-for-API-Developers/API04-Lack-of-Resources-and-Rate-Limiting/README.md)
   * [API05: Broken Function Level Authorization](Hacking-for-API-Developers/API05-Broken-Function-Level-Authorization/README.md)
   * [API06: Mass Assignment](Hacking-for-API-Developers/API06-Mass-Assignment/README.md)
   * [API07: Security Misconfiguration](Hacking-for-API-Developers/API07-Security-Misconfiguration/README.md)
   * [API08: Injection](Hacking-for-API-Developers/API08-Injection/README.md)
   * [API09: Improper Assets Management](Hacking-for-API-Developers/API09-Improper-Assets-Management/README.md)
   * [API10: Insufficient Logging and Monitoring](Hacking-for-API-Developers/API10-Insufficient-Logging-and-Monitoring/README.md)

## Install OWASP Juice Shop

Make sure you have docker installed and ready on your machine.

Follow the setup instructions on https://github.com/juice-shop/juice-shop#setup  
(Installation using _Docker Container_ recommended).

```
docker pull bkimminich/juice-shop:v14.2.0
docker run --rm -p 3000:3000 bkimminich/juice-shop:v14.2.0
```

You may try a later version of the [OWASP JuiceShop](https://github.com/bkimminich/juice-shop) but the challenges and/or the associated hints might not be applicable any more!

Browse to [localhost:3000](http://localhost:3000).

## Useful links


* [Complete documentation about OWASP Juice Shop](https://bkimminich.gitbooks.io/pwning-owasp-juice-shop/content/)
* [The Page of the OWASP Juice Shop Project in The OWASP Foundation Wiki.](https://www.owasp.org/index.php/OWASP_Juice_Shop)
* [The OWASP Top 10: Description of each application security risk in OWASP](https://www.owasp.org/images/7/72/OWASP_Top_10-2017_%28en%29.pdf.pdf)
* [Postman API Development Environment](https://www.getpostman.com/downloads/)
* [Httpie Http command line client](https://httpie.org/)
* [Curl Http command line client](https://curl.haxx.se/)
* [OWASP ZAP Web Security Proxy & Scanner](https://github.com/zaproxy/zaproxy/wiki/Downloads)
