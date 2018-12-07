# Challenge Collection 3: Broken Authentication

Broken Authentication is the consequence of programming flaws in session management and authentication. Insufficient conception of identity and access controll can lead to security gaps. Attackers are able to exploit these security gaps by using automated tools for brute-force-attacks. The worst case is that attackers gain access to administrator accounts, get sensitive data and the possibility to identity theft.

   * [Challenge 3.1: Brute-force attack](#challenge-31-brute-force-attack)
      * [Tips:](#tips)
   * [Challenge 3.2: Create an administrator account](#challenge-32-create-an-administrator-account)
   * [Challenge 3.3: Take over the session of a previously logged in user](#challenge-33-take-over-the-session-of-a-previously-logged-in-user)

**HINT:** Make sure that you download [Postman](https://www.getpostman.com/apps).

## Challenge 3.1: Brute-force attack
Log in with the original password of the administrator without SQL injection or the changing password. Detect the password with a brute force attack. For example, you could use https://github.com/zaproxy/zaproxy/wiki/Downloads.

### Tips:

1. **Tip:** Have a look at [Challenge 1.2](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%201:%20Broken%20Access%20Control#challenge-12-find-the-admin-page) if you don't know the email.

2. **Tip:** Try to attack the POST call on http://localhost:3000/rest/user/login. If you solved [Challenge 2.1](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%202:%20Injection#challenge-21-log-in-as-administrator) with OWASP ZAP, you will know the process.

3. **Tip:** You need a wordlist with a top list of the weakest passwords. Browse to https://github.com/danielmiessler/SecLists/tree/master/Passwords.

## Challenge 3.2: Create an administrator account
Create an account that has all administrator rights.

1. **Tip:** [Postman](https://www.getpostman.com/apps) could help you.

2. **Tip:** Have a look at the GET-Requests in the console of the web development tool.

3. **Tip:** The GET-Requests sent while interacting with the administration section might help you.

## Challenge 3.3: Take over the session of a previously logged in user
Switch to the session of a previously logged in user without reusing his user credentials. You have to log in the user account that you want to attack at least one time. After a logout, you should try to return to this session without the login section.

1. **Tip:** Capture all GET- and POST-requests while logging in by ticking the `Persist Logs` option in the console of the web development tool or leaving the console open.

2. **Tip:** The token in the tab `Response` might be useful.

3. **Tip:** Have a look at the tab `Storage`.

4. **Tip:** Log in while observing the tab `Storage`.

