# A03: Injection

An application is vulnerable to attack when:

* User-supplied data is not validated, filtered, or sanitized by the application.
* Dynamic queries or non-parameterized calls without context-aware escaping are used directly in the interpreter.
* Hostile data is used within object-relational mapping (ORM) search parameters to extract additional, sensitive records.
* Hostile data is directly used or concatenated. The SQL or command contains the structure and malicious data in dynamic queries, commands, or stored procedures.

Some of the more common injections are SQL, NoSQL, OS command, Object Relational Mapping (ORM), LDAP, and Expression Language (EL) or Object Graph Navigation Library (OGNL) injection. The concept is identical among all interpreters.

## Table of Challenges

   * [SQL Injection and NoSQL Injection](#sql-injection-and-nosql-injection)
      * [Challenge 3.1: Log in as administrator](#challenge-31-log-in-as-administrator)
         * [Tips:](#tips)
      * [Challenge 3.2: Modify a product review](#challenge-32-modify-a-product-review)
         * [Tips:](#tips-1)
      * [Challenge 3.3: Modify multiple product reviews at once](#challenge-33-modify-multiple-product-reviews-at-once)
         * [Tips:](#tips-2)
      * [Challenge 3.4: Cause the server of the juice shop to sleep for 2 seconds](#challenge-34-cause-the-server-of-the-juice-shop-to-sleep-for-2-seconds)
         * [Tips:](#tips-3)
   * [Cross-Site Scripting (XSS)](#cross-site-scripting-xss)
      * [Challenge 5.1: Persisted XSS with Postman](#challenge-51-persisted-xss-with-postman)
         * [Tips:](#tips)
      * [Challenge 5.2: Persisted XSS with Postman (2)](#challenge-52-persisted-xss-with-postman-2)
         * [Tips:](#tips-1)
      * [Challenge 5.3: Persisted XSS through the UI](#challenge-53-persisted-xss-through-the-ui)
         * [Tips:](#tips-2)
      * [Challenge 5.4: Reflected XSS](#challenge-54-reflected-xss)
         * [Tips:](#tips-3)
      * [Challenge 5.5: DOM XSS](#challenge-55-dom-xss)
         * [Tips:](#tips-4)      

**HINT:** Make sure that you download [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads) and [Postman](https://www.getpostman.com/apps).

## Challenges

### SQL Injection and NoSQL Injection

**SQL injection** flaws are introduced when software developers create dynamic database queries constructed with string concatenation which includes user supplied input.

**NoSQL injection** attacks may execute in different areas of an application than traditional SQL injection. Where SQL injection would execute within the database engine, NoSQL variants may execute during within the application layer or the database layer, depending on the NoSQL API used and data model. Typically NoSQL injection attacks will execute where the attack string is parsed, evaluated, or concatenated into a NoSQL API call.

### Challenge 3.1: Log in as administrator
Get access to the account of the administrator.

#### Tips:

1. **Tip:** His email is admin@juice-sh.op.

2. **Tip:** You don't need the matching password to solve the challenge.

3. **Tip:** Try to corrupt the underlying **SQL** Query by inserting invalid input. For example, an apostrophe `'` might help.

4. **Tip:** Have a look at the **Web Development Tool**.


### Challenge 3.2: Modify a product review
Modify the product reviews of the product `Apple Juice (1000 ml)` without being logged in the administrator account.  
Change the first review with the text `One of my favorites!` written by `admin@juice-sh.op` to `Apple Juice has been hacked!`.

#### Tips:

1. **Tip:** Inspect the HTTP calls while opening a product review.

2. **Tip:** Find out, which parameters you have to manipulate. Postman will help you with modifying these parameters.

3. **Tip:** You have to slightly change the **GET** call that you have observed in your console.


### Challenge 3.3: Modify multiple product reviews at once
Modify multiple product reviews at once by changing the text of all reviews to `Juice Shop has been hacked!`.

#### Tips: 

1. **Tip:** The process of [Challenge 3.2](#challenge-32-modify-a-product-review) might help you.

2. **Tip:** Remember the architecture overview - Juiceshop uses MarsDB, a NodeJS MongoDB clone.

3. **Tip:** You need to use a query operator to solve this challenge.


### Challenge 3.4: Cause the server of the juice shop to sleep for 2 seconds
Try to lead the server to sleep for 2 seconds.

#### Tips:

1. **Tip:** Find a way to interact with the API. [Challenge 3.2](#challenge-32-modify-a-product-review) and [challenge 3.3](#challenge-33-modify-multiple-product-reviews-at-once) might reveal a possibility where you can exploit a parameter.

2. **Tip:** You need to inject a sleep function as a parameter.

## Cross-Site scripting (XSS)

**Cross-Site scripting (XSS)** is the injection of malicious code in web applications. It allows attackers to execute JavaScript in the browser of another user. This can lead to session stealing, account takeover or the download of malicious software, as the code of the attacker becomes a part of the HTML source of the application.  

**HINT:** [Install Postman](https://www.getpostman.com/apps) if you haven't done yet.

## Challenge 5.1: Persisted XSS with Postman
Try to perform a **persisted XSS attack** by affecting the table of the **Users** with **Postman**. Every call of the **administration section** should alert a dialog with the content `xss`.  
To perform XSS, use iframe: <code><iframe src="javascript:alert(&grave;xss&grave;)"></code>.

### Tips:

1. **Tip:** Try to interact with the **users API**.

2. **Tip:** If you have solved Challenge [2.2](https://github.com/nt-ca-aqe/developer-security-training/tree/master/Challenges/Challenge-2#challenge-22-create-an-administrator-account), you will know how to interact with the **users API**.

3. **Tip:** You have to send a **POST** call.

4. **Tip:** Consider that there are several parameters that you must pass, although the content of these parameters doesn't matter for your result.

5. **Tip:** There might be characters you must escape.


## Challenge 5.2: Persisted XSS with Postman (2)
Try to perform a **persisted XSS attack** by affecting the table of the **Products** with **Postman**. Every call containing the new product should alert a dialog with the content `xss`.  
To perform XSS, use iframe: <code><iframe src="javascript:alert(&grave;xss&grave;)"></code>

### Tips:

1. **Tip:** Try to interact with the **products API**.

2. **Tip:** The process is nearly similar to [Challenge 5.1](https://github.com/nt-ca-aqe/developer-security-training/tree/master/Challenges/Challenge-5#challenge-51-persisted-xss-with-postman), so have a look at the tips for this challenge.

3. **Tip:** Consider that you need an **authorization**.

4. **Tip:** Look about the **session token**.


## Challenge 5.3: Persisted XSS through the UI
Try to perform a **persisted XSS attack** by affecting the list of the **customer feedback**. Every call containing customer feedback should alert a dialog with the content `xss`.  
To perform XSS, use iframe: <code><iframe src="javascript:alert(&grave;xss&grave;)"></code>

### Tips:

1. **Tip:** **Customer feedback** can be given here: `http://localhost:3000/#/contact`.

2. **Tip:** You have to modify the iframe element, as the common input won't be rendered as the similar output.

3. **Tip:** While visiting sites that contain customer feedback, check the sources (tab `Inspector` in **Firefox** or tab `Elements` in **Chrome**) to recognize how the iframe element is embedded in the HTML sources.


## Challenge 5.4: Reflected XSS
Try to perform a **reflected XSS attack** by finding a suitable input field.  
To perform XSS, use iframe: <code><iframe src="javascript:alert(&grave;xss&grave;)"></code>

### Tips:

1. **Tip:** To find the suitable area, you have to log in first with any account.

2. **Tip:** Have a look at the options of the account area.


## Challenge 5.5: DOM XSS
Try to perform a **DOM-based XSS attack** by finding a suitable input field.  
To perform XSS, use iframe: <code><iframe src="javascript:alert(&grave;xss&grave;)"></code>

### Tips:

1. **Tip:** The input field you need here is not hidden at all.
