# Challenge Collection 1: Broken Access Control

**Broken Access Control** comprises security flaws caused by fragile implemented access rights in web applications. The decision whether a user is allowed to call a certain resource depends on factors like the confidentiality of the requested source and the role of the requesting user. However, security gaps in this area are common, because several contents haven't been secured enough in programming. This can lead to horrible consequences, as an unauthorized user is able to take over the administration and obtain, manipulate or delete important and sensitive data.

   * [Prepare for the challenges:](#prepare-for-the-challenges)
   * [Challenge 1.1: Find the Score Board with the challenge overview](#challenge-11-find-the-score-board-with-the-challenge-overview)
      * [Tips:](#tips)
   * [Challenge 1.2: Find the Admin Page](#challenge-12-find-the-admin-page)
      * [Tips:](#tips-1)
   * [Challenge 1.3: Show the basket of another user:](#challenge-13-show-the-basket-of-another-user)
      * [Tips:](#tips-2)
   * [Challenge 1.4: Write a comment in the name of another user:](#challenge-14-write-a-comment-in-the-name-of-another-user)
      * [Tips:](#tips-3)
   * [Challenge 1.5: Change the description of the product OWASP SSL Advanced Forensic Tool (O-Saft)](#challenge-15-change-the-description-of-the-product-owasp-ssl-advanced-forensic-tool-o-saft)
      * [Tips:](#tips-4)

**HINT:** Make sure that you download [Postman](https://www.getpostman.com/apps).

## Prepare for the challenges:
Before starting the first challenge, try to become familiar with the **OWASP Juice Shop**. Try out the functionalities in the menu bar like the `Contact Us`-Button or the `Search`-Field, have a look at the **Login Site** and **create an account** in the **OWASP Juice Shop**. After you have done the **user registration**, there might be several new functions as a logged in user which you should also try out. 

## Challenge 1.1: Find the Score Board with the challenge overview
The **Score Board** provides an overview of all challenges in the **OWASP Juice Shop**. This subpage cannot be found by navigating through the application, because there is no direct button redirecting to the Score Board yet.  
Try to find this secret subpage!

### Tips:

1. **Tip:** You can try to guess the URL.

2. **Tip:** Have a look at the **Web Development Tools** of **Mozilla Firefox** or **Google Chrome**

3. **Tip:** **Firefox Users**: The tab `Debugger` --> `Sources` of the **Web Development Tool** will help you.  
**Google Chrome Users**: The tab `Sources` --> `Page` of the **Web Development Tool** will help you.

4. **Tip:** The file `main.js` includes important information.


## Challenge 1.2: Find the Admin Page
Similar to the **Score Board**, the **Admin Page** is also hidden in the application and cannot be called by clicking a certain link.  
Try to find this subpage!

### Tips:

1. **Tip:** Have a look at the tips of [Challenge 1.1](https://github.com/nt-ca-aqe/developer-security-training/tree/master/Challenges/Challenge-1#challenge-11-find-the-score-board-with-the-challenge-overview)

2. **Tip:** Make sure that you are a user in the **OWASP Juice Shop**

3. **Information:** You cannot access this page without being an authorized user. Probably you could already guess that from the code. Note down this path for later challenges.


## Challenge 1.3: Show the basket of another user:
Try to show a **basket** of a registered user of the **OWASP Juice Shop** which is not currently logged in.

### Tips:

1. **Tip:** While interacting with the **basket**, have a look at the HTTP calls

2. **Tip:** **Firefox Users**: The tab `Storage` might help you  
**Chrome Users**: The tab `Application` might help you


## Challenge 1.4: Write a comment in the name of another user:
Submit a comment in the `Contact Us` section in the name of the administrator.

### Tips:

1. **Tip:** The **Web Development Tool** could help you

2. **Tip:** **Firefox Users**: The tab `Console` might help you.  
**Chrome Users**: The tab `Elements` might help you.

3. **Tip:** Search in the source for hidden input fields.

4. **Tip:** Think about a certain attribute you have to change in the database for modifying the author of the written comment. A search in the sources after the name of this attribute might help you.


## Challenge 1.5: Change the description of the product "OWASP SSL Advanced Forensic Tool (O-Saft)"
Replace the description of the product **OWASP SSL Advanced Forensic Tool (O-Saft)**. The description should only consist of the word `More...`, which links to `http://kimminich.de` (the developer of the **OWASP Juice Shop**).

### Tips:

1. **Tip:** Capture the HTTP calls in the `Console` while interacting with the product.

2. **Tip:** Try to find out the id of **OWASP SSL Advanced Forensic Tool (O-Saft)**.

3. **Tip:** Try to interact with the **API** via [Postman](https://www.getpostman.com/apps).

4. **Tip:** The sources could reveal the exact path to interact with the **API**.

5. **Tip:** You can solve the challenge by submitting one **PUT** request.
