# Challenge Collection 3: Broken Authentication

*--INTRODUCTION TEXT--*

## Challenge 3.1: Log in with the original password of the administrator (without SQL injection or changing password)
Try to find out the original password of the administrator account. Detect the password with a brute force attack. For example, you could use https://github.com/zaproxy/zaproxy/wiki/Downloads.

### Tips:

1. **Tip:** Have a look at [Challenge 1.2](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%201:%20Broken%20Access%20Control#challenge-12-find-the-admin-page) if you don't know the email.

2. **Tip:** Try to attack the POST call on http://localhost:3000/rest/user/login. If you solved [Challenge 2.1](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%202:%20Injection#challenge-21-log-in-as-administrator) with OWASP ZAP, you will know the process.

3. **Tip:** You need a wordlist with a top list of the weakest passwords. Browse to https://github.com/danielmiessler/SecLists/tree/master/Passwords.
