# Challenge Collection 6: Using Components With Known Vulnerabilities
The challenges in this chapter are all about security issues of libraries or other 3rd party components the application uses internally.

* [Challenge 6.1: Inform the shop about a vulnerable library it is using](#challenge-61-inform-shop-about-vulnerable-library)


## Challenge 6.1: Inform the shop about a vulnerable library it is using
Juice Shop depends on a JavaScript library with known vulnerabilities. Check online the dependencies in the file package.json.bak.

1. Call http://localhost:3000/ftp/package.json.bak%2500.md and save file 
2. Checking the dependencies in package.json.bak for known vulnerabilities online will give you a match (at least) for

   sanitize-html: Sanitization of HTML strings is not applied recursively to input, allowing an attacker to potentially inject script and other markup (see https://snyk.io/vuln/npm:sanitize-html:20160801)
   express-jwt: Inherits an authentication bypass and other vulnerabilities from its dependencies (see https://app.snyk.io/test/npm/express-jwt/0.1.3)

3. Visit http://localhost:3000/#/contact
   Submit your feedback with the string pair sanitize-html and 1.4.2 appearing somewhere in the comment. Alternatively you can submit express-jwt and 0.1.3
