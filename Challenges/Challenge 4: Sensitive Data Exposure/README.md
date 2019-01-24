# Challenge Collection 4: Sensitive Data Exposure

Use of weak encryption or hashing algorithms might lead to **Sensitive Data Exposure**. The danger of plain text being displayed in data traffic can provoke the discluse of sensitive personal information like user credentials or credit cards information.

   * [Challenge 4.1: Log in with MC SafeSearch's original password (without SQL injection or changing password)](#challenge-41-log-in-with-mc-safesearchs-original-password-without-sql-injection-or-changing-password)
      * [Tips:](#tips)
   * [Challenge 4.2: Find and open a confidential document](#challenge-42-find-and-open-a-confidential-document)
      * [Tips:](#tips-1)

**HINT:** [Install Postman](https://www.getpostman.com/apps) and [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads) if you haven't done yet.


## Challenge 4.1: Log in with MC SafeSearch's original password (without SQL injection or changing password)
Try to find out the original password of **MC SafeSearch's account**.

### Tips:

1. **Tip:** Have a look at [Challenge 1.2](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%201:%20Broken%20Access%20Control#challenge-12-find-the-admin-page) if you don't know the email.

2. **Tip:** The **admin section** of the **OWASP Juice Shop** could reveal sensitive data.

3. **Tip:** The **Web Development Tool** of your browser will help you.

4. **Tip:** Observe the HTTP calls while interacting with the **admin section**.


## Challenge 4.2: Find and open a confidential document

### Tips:

1. **Tip:** A scan of the **OWASP Juice Shop** by [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads) might help you.

2. **Tip:** Search after hidden links to areas you haven't seen before (with **OWASP ZAP** or in the user interface).

3. **Tip:** Inspect the `About Us` section.
