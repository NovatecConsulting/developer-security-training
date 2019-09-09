# Security Training for Web Developers based on OWASP Juice Shop

In this training, the most critical risks in software applications are presented to teach web developers how to develop 
a secure web application.  

After introducing the [Open Web Application Security Project Top 10 2017 (OWASP Top 10 2017)](https://www.owasp.org/index.php/Category:OWASP_Top_Ten_2017_Project), a selection of the application security 
risks listed in the OWASP Top 10 will be described step by step.  
Each security risk of the selection has its own folder with certain challenges to solve. In this challenges, 
the participants of the course have to find various security flaws in 
the [OWASP Juice Shop](https://github.com/bkimminich/juice-shop), which is an intentionally vulnerable web application. 
The descriptions of the challenges include tips to help finding the right way of hacking the application. 

Always read at first only one hint, then try to solve the challenge. If you don't have a clue of going forward, then read 
the following tip.  

Also, you can find the final solution for each challenge in the sub folder [Solutions](Solutions). But please DO NOT cheat 
and look here before trying to solve this yourself.

**IMPORTANT:** It is recommended to do the security training in the right order, as the challenges depend on each other.

## Setup

### OWASP Juice Shop

Follow the setup instructions on https://github.com/bkimminich/juice-shop/blob/master/README.md  
(Installation "From Sources" or "Docker Container" recommended).

```
docker pull bkimminich/juice-shop
docker run --rm -p 3000:3000 bkimminich/juice-shop:v9.0.1
```

### Web Proxy

#### OWASP ZAP

Follow the setup instructions on https://github.com/zaproxy/zaproxy/wiki/Downloads.  

Starting with version 2.8.0, OWASP ZAP now includes a _Heads Up Display_. Look into the
corresponding [OWASP ZAP HUD github project](https://github.com/zaproxy/zap-hud) to learn more about this 
fascinating new feature.

### REST API clients

#### Postman

To make calls to REST API of the Juice Shop via a comfortable UI you may use Postman.  
Follow the setup instructions on https://www.getpostman.com/apps.

#### Httpie

If you are more used to make calls to REST API of the Juice Shop via command line you may try Httpie.  
Follow the setup instructions on https://httpie.org.

#### Curl

If you are more used to make calls to REST API of the Juice Shop via command line you also may try the classic Curl.  
Follow the setup instructions on https://curl.haxx.se.

### The Challenges

* [Challenge 1: Broken Access Control](Challenge-1/README.md)
* [Challenge 2: Broken Authentication](Challenge-2/README.md)
* [Challenge 3: Injection](Challenge-3/README.md)
* [Challenge 4: Sensitive Data Exposure](Challenge-4/README.md)
* [Challenge 5: Cross-Site Scripting (XSS)](Challenge-5/README.md)
* [Challenge 6: Using Components With Known Vulnerabilities](Challenge-6/README.md)
* [Challenge 7: Security Misconfiguration](Challenge-7/README.md)
