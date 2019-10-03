# Security Training for Web Developers

In this security training, the most critical risks in software applications are presented to teach web developers how to develop a secure web application.  
After introducing the Open Web Application Security Project Top 10 (OWASP Top 10), a selection of the application security risks listed in the OWASP Top 10 will be described step by step. Each security risk of the selection has its own folder with certain challenges to solve. 
In these challenges, the participants of the course have to find various security flaws in the [OWASP Juice Shop](https://github.com/bkimminich/juice-shop), which is an intentionally vulnerable web application.
The descriptions of these challenges are in the folder [Challenges](Challenges).  
Also, you have the opportunity to view a Spring Boot Application, which shows the best practice for implementing those functions which are implemented with security flaws in OWASP Juice Shop: 

Go to folder [Spring Boot Application](Spring-Boot-Application) to run this app.

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
1. Definitions
2. IT Security
3. [Open Web Application Security Project (OWASP)](https://owasp.org/)
4. [OWASP Juice Shop](https://github.com/bkimminich/juice-shop) 
5. Security Tools
6. [Spring Boot Application](Spring-Boot-Application/README.md)
7. [Selected Security Risks](Challenges/README.md)
   * [Challenges Lab 1: Broken Access Control](Challenges/Challenge-1/README.md)
   * [Challenges Lab 2: Broken Authentication](Challenges/Challenge-2/README.md)
   * [Challenges Lab 3: Injection](Challenges/Challenge-3/README.md)
   * [Challenges Lab 4: Sensitive Data Exposure](Challenges/Challenge-4/README.md)
   * [Challenges Lab 5: Cross-Site Scripting (XSS)](Challenges/Challenge-5/README.md)
   * [Challenges Lab 6: Using Components With Known Vulnerabilities](Challenges/Challenge-6/README.md)
   * [Challenges Lab 7: Security Misconfiguration](Challenges/Challenge-7/README.md)

## Install OWASP Juice Shop

Make sure you have docker installed and ready on your machine.

Execute the following command in a shell of your choice (using target version 8.5.1 for challenges to solve)
```
docker run --rm -p 3000:3000 bkimminich/juice-shop:v8.5.1
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
