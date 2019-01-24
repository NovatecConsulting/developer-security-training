# Challenge Collection 3: Injection

**Injection** is the process of inserting malicious code. Every application that uses an interpreter could contain injection flaws. The impacts of injection are critical, because attacks can lead to disclosure to unauthorized parties, data loss and corruption.

   * [Challenge 3.1: Log in as administrator](#challenge-31-log-in-as-administrator)
      * [Tips:](#tips)
   * [Challenge 3.2: Modify a product review](#challenge-32-modify-a-product-review)
      * [Tips:](#tips-1)
   * [Challenge 3.3: Modify multiple product reviews at once](#challenge-33-modify-multiple-product-reviews-at-once)
      * [Tips:](#tips-2)
   * [Challenge 3.4: Cause the server of the juice shop to sleep for 2 seconds](#challenge-34-cause-the-server-of-the-juice-shop-to-sleep-for-2-seconds)
      * [Tips:](#tips-3)

**HINT:** Make sure that you download [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads) and [Postman](https://www.getpostman.com/apps).

## Challenge 3.1: Log in as administrator
Get access to the account of the administrator.

### Tips:

1. **Tip:** Have a look at [Challenge 1.2](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%201:%20Broken%20Access%20Control#challenge-12-find-the-admin-page) if you don't know the email.

2. **Tip:** You don't need the matching password to solve the challenge.

3. **Tip:** Try to corrupt the underlying **NoSQL** Query by inserting invalid input. For example, an apostrophe `'` might help.

4. **Tip:** Have a look at the **Web Development Tool**.


## Challenge 3.2: Modify a product review
Modify the product reviews of the product `Apple Juice (1000 ml)` without being logged in the administrator account.  
Change the first review with the text `One of my favorites!` written by `admin@juice-sh.op` to `Apple Juice has been hacked!` and manipulate the author so that **Jim's email** appears.

### Tips:

1. **Tip:** Inspect the HTTP calls while opening a product review.

2. **Tip:** Find out, which parameters you have to manipulate. Postman will help you with modifying these parameters.

3. **Tip:** You have to slightly change the **GET** call that you have observed in your console.


## Challenge 3.3: Modify multiple product reviews at once
Modify multiple product reviews at once by changing the text of all reviews to `Juice Shop has been hacked!`.

### Tips: 

1. **Tip:** The process of [Challenge 3.2](#challenge-32-modify-a-product-review) might help you.

2. **Tip:** You need to use a query operator to solve this challenge.


## Challenge 3.4: Cause the server of the juice shop to sleep for 2 seconds
Try to lead the server to sleep for 2 seconds.

### Tips:

1. **Tip:** Find a way to interact with the API. [Challenge 3.2](#challenge-32-modify-a-product-review) and [challenge 3.3](#challenge-33-modify-multiple-product-reviews-at-once) might reveal a possibility where you can exploit a parameter.

2. **Tip:** You need to inject a sleep function as a parameter.
