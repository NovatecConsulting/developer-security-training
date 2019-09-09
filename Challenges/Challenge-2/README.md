# Challenge Collection 2: Broken Authentication

**Broken Authentication** is the consequence of programming flaws in session management and authentication. Insufficient conception of identity and access control can lead to security gaps. Attackers are able to exploit these security gaps by using automated tools for brute-force-attacks. The worst case is that attackers gain access to administrator accounts, get sensitive data and the possibility to identity theft.

   * [Challenge 2.1: Brute-force attack](#challenge-21-brute-force-attack)
      * [Tips:](#tips)
   * [Challenge 2.2: Create an administrator account](#challenge-22-create-an-administrator-account)
      * [Tips:](#tips-1)
   * [Challenge 2.3: Take over the session of a previously logged in user](#challenge-23-take-over-the-session-of-a-previously-logged-in-user)
      * [Tips:](#tips-2)
   * [Challenge 2.4: Change the password of the user account of Bender](#challenge-24-change-the-password-of-the-user-account-of-bender)
      * [Tips:](#tips-3)
   * [Challenge 2.5: Log in with the user account of Bjoern](#challenge-25-log-in-with-the-user-account-of-bjoern)
      * [Tips:](#tips-4)

**HINT:** Make sure that you download [Postman](https://www.getpostman.com/apps) and [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads).

## Challenge 2.1: Brute-force attack
Log in with the original password of the administrator without SQL injection or changing the password. Detect the password with a **brute force attack**. For example, you could use https://github.com/zaproxy/zaproxy/wiki/Downloads.

### Tips:

1. **Tip:** His email is admin@juice-sh.op.

2. **Tip:** Try to attack the **POST** call on http://localhost:3000/rest/user/login with [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads).

3. **Tip:** You need a word list with a top list of the weakest passwords. Browse to https://github.com/danielmiessler/SecLists/tree/master/Passwords.


## Challenge 2.2: Create an administrator account
Create an account that has all administrator rights.

### Tips:

1. **Tip:** [Postman](https://www.getpostman.com/apps) could help you.

2. **Tip:** Have a look at the **GET**-Requests in the console of the **Web Development Tool**.

3. **Tip:** The **GET**-Requests sent while interacting with the **administration section** might help you.


## Challenge 2.3: Take over the session of a previously logged in user
Switch to the session of a previously logged in user without reusing his user credentials. You have to log in the user account that you want to attack at least one time. After a logout, you should try to return to this session without the login section.

### Tips:

1. **Tip:** Capture all **GET** and **POST** requests while logging in by ticking the `Persist Logs` option in the console of the **Web Development Tool** or leaving the console open.

2. **Tip:** The token in the tab `Response` might be useful.

3. **Tip:** Have a look at the tab `Storage`.

4. **Tip:** Log in while observing the tab `Storage`.


## Challenge 2.4: Change the password of the user account of Bender
Change the password of the user account of Bender without using the forgot password mechanism to **slurmCl4ssic**, cracking the password hash or SQL injection. You may use SQL injection for the first login, but the final change of the password shouldn't be a result of this method.

### Tips:

1. **Tip:** His email is bender@juice-sh.op.

2. **Tip:** Inspect the HTTP calls while interacting with the `change password` mechanism.

3. **Tip:** [Postman](https://www.getpostman.com/apps) will help you.


## Challenge 2.5: Log in with the user account of Bjoern
Log in with the original user credentials of Bjoern (without SQL injection).

### Tips:

1. **Tip:** His email is bjoern.kimminich@gmail.com.

2. **Tip:** Bjoern's encrypted password is not a [MD5](https://en.wikipedia.org/wiki/MD5) hash.

3. **Tip:** Brute-force attacks and decrypting the password hash won't be possible.

4. **Tip:** The registration has been performed by **Google OAuth**.

5. **Tip:** Have a look at the tab `Debugger` (**Firefox**) or `Sources` (**Chrome**).


