# Challenge Collection 2: Injection

*-- Introduction Text --*

   * [Challenge 2.1: Log in as administrator](#challenge-21-log-in-as-administrator)
      * [Tips:](#tips)
   * [Challenge 2.2: Modify a product review](#challenge-22-modify-a-product-review)
      * [Tips:](#tips-1)
   * [Challenge 2.3: Modify multiple product reviews at once](#challenge-23-modify-multiple-product-reviews-at-once)
      * [Tips:](#tips-2)
   * [Challenge 2.4: Cause the server of the juice shop to sleep for 2 seconds](#challenge-24-cause-the-server-of-the-juice-shop-to-sleep-for-2-seconds)
      * [Tips:](#tips-3)

**HINT:** Make sure that you download [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads) and [Postman](https://www.getpostman.com/apps).

## Challenge 2.1: Log in as administrator
Get access to the account of the administrator.

### Tips:

1. **Tip:** Have a look at [Challenge 1.2](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%201:%20Broken%20Access%20Control#challenge-12-find-the-admin-page) if you don't know the email.

2. **Tip:** You don't need the matching password to solve the challenge.

3. **Tip:** Try to corrupt the underlying NoSQL-Query by inserting invalid input. For example, an apostrophe `'` might help.

4. **Tip:** Have a look at the web development tool.


## Challenge 2.2: Modify a product review

Modify the product reviews of the product `Apple Juice (1000 ml)` without being logged in the administrator account.  
Change the first review with the text `One of my favorites!` written by `admin@juice-sh.op` to `Apple Juice has been hacked!` and manipulate the author so that Jim's email appears.

### Tips:

1. **Tip:** Inspect the HTTP calls while opening a product review.

2. **Tip:** Find out, which parameters you have to manipulate. Postman will help you with modifying these parameters.

3. **Tip:** You have to slightly change the GET call that you have observed in your console.


## Challenge 2.3: Modify multiple product reviews at once
Modify multiple product reviews at once by changing the text of all reviews to `Juice Shop has been hacked!`.

### Tips: 

1. **Tip:** The process of [Challenge 2.2](#challenge-22-modify-a-product-review) might help you.

2. **Tip:** You need to use a query operator to solve this challenge.


## Challenge 2.4: Cause the server of the juice shop to sleep for 2 seconds
Try to lead the server to sleep for 2 seconds.

### Tips:

1. **Tip:** Find a way to interact with the API. [Challenge 2.2](#challenge-22-modify-a-product-review) and [challenge 2.3](#challenge-23-modify-multiple-product-reviews-at-once) might reveal a possibility where you can exploit a parameter.

2. **Tip:** You need to inject a sleep function as a parameter.
