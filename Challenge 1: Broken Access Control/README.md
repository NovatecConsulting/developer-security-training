# Challenge Collection 1: Broken Access Control

*-- Introduction Text --*

   * [Prepare for the challenges:](#prepare-for-the-challenges)
   * [Challenge 1.1: Find the Score Board with the challenge overview](#challenge-11-find-the-score-board-with-the-challenge-overview)
      * [Tips:](#tips)
   * [Challenge 1.2: Find the Admin Page](#challenge-12-find-the-admin-page)
      * [Tips:](#tips-1)
   * [Challenge 1.3: Make sure that the shop loses all 5-Star ratings](#challenge-13-make-sure-that-the-shop-loses-all-5-star-ratings)
      * [Tips:](#tips-2)
   * [Challenge 1.4: Show the basket of another user:](#challenge-14-show-the-basket-of-another-user)
      * [Tips:](#tips-3)
   * [Challenge 1.5: Write a comment in the name of another user:](#challenge-15-write-a-comment-in-the-name-of-another-user)
      * [Tips:](#tips-4)

## Prepare for the challenges:
Before starting the first challenge, try to become familiar with the OWASP Juice Shop. Try out the functionalities in the menu bar like the "Contact Us"-Button or the "Search"-Field, have a look at the Login Site and create an account in the Juice Shop. After you have done the user registration, there might be several new functions as a logged in user which you should also try out. 

## Challenge 1.1: Find the Score Board with the challenge overview
The Score Board provides an overview of all challenges in the OWASP Juice Shop. This subpage cannot be found by navigating through the application, because there is no direct button redirecting to the Score Board yet.
Try to find this secret subpage!

### Tips:

1. **Tip:** You can try to guess the URL.

2. **Tip:** Have a look at the web development tools of Mozilla Firefox or Google Chrome

3. **Tip:** Firefox Users: The tab `Debugger` --> `Sources` of the the web development tool will help you.
Google Chrome Users: The tab `Sources` --> `Page` of the the web development tool will help you.

4. **Tip:** The file `main.js` includes important information.


## Challenge 1.2: Find the Admin Page
Similar to the Score Board, the Admin Page is also hidden in the application and cannot be called by clicking a certain link.
Try to find this subpage!

### Tips:

1. **Tip:** Have a look at the tips of [Challenge 1.1](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%201:%20Broken%20Access%20Control#challenge-11-find-the-score-board-with-the-challenge-overview)

2. **Tip:** Make sure that you are a user in the OWASP Juice Shop


## Challenge 1.3: Make sure that the shop loses all 5-Star ratings
Try to remove all entrys in the customer feedback-section, which have a rating of 5 stars.

### Tips:

1. **Tip:** After solving [challenge 1.2](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%201:%20Broken%20Access%20Control#challenge-12-find-the-admin-page), you need only one step to finish this task.


## Challenge 1.4: Show the basket of another user:
Try to show a basket of a registered user of the OWASP Juice Shop which is not currently logged in.

### Tips:

1. **Tip:** While interacting with the basket, have a look at the HTTP calls

2. **Tip:** Firefox Users: The tab `Storage` might help you
Chrome Users: The tab `Application` might help you


## Challenge 1.5: Write a comment in the name of another user:
Submit a comment in the `Contact Us` section in the name of the administrator.

### Tips:

1. **Tip:** The web development tool could help you

2. **Tip:** Firefox Users: The tab `Console` might help you.
Chrome Users: The tab `Elements` might help you.

3. **Tip:** Search in the source after hidden input fields.

4. **Tip:** Think about a certain attribute you have to change in the database for modifying the author of the written comment. A search in the sources after the name of this attribute might help you.
