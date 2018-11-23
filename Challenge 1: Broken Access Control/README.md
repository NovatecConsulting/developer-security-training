# Challenge Collection 1: Broken Access Control

*-- Introduction Text --*

## Prepare for the challenges:
Before starting the first challenge, try to become familiar with the OWASP Juice Shop. Try out the functions in the menu bar like the "Contact Us"-Button or the "Search"-Field, have a look at the Login Site and create an account in the Juice Shop. After you have done the user registration, there might be several new functions as a logged in user which you can also try out. 

## Challenge 1.1: Find the Score Board with the challenge overview
The Score Board provides an overview of all challenges in the OWASP Juice Shop. This subpage cannot be found by navigating through the application, because there is no direct button redirecting to the Score Board yet.
Try to find this secret subpage!

### Tips:

1. Tip: You can try to guess the URL.

2. Tip: Have a look at the web development tools of Mozilla Firefox or Google Chrome

3. Tip: Firefox Users: The tab Debugger --> Sources of the the web development tool will help you.
Google Chrome Users: The tab Sources --> Page of the the web development tool will help you.

4. Tip: The file "main.js" includes important information.


## Challenge 1.2: Find the Admin Page
Similar to the Score Board, the Admin Page is also hidden in the application and cannot be called by clicking a certain link.
Try to find this subpage!

### Tips:

1. Tip: Have a look at the tips of Challenge 1.1

2. Tip: Make sure that you are a User in the OWASP Juice Shop


## Challenge 1.3: Make sure that the shop loses all 5-Star ratings
Try to remove all entrys in the customer feedback-section, which have a rating of 5 stars.

1. Tip: After solving challenge 1.2, you need only one step to finish this task.


## Challenge 1.4: Show the basket of another user:
Try to show a basket of a registered user of the OWASP Juice Shop which is not currently logged in.

1. Tip: While interacting with the basket, have a look at the HTTP calls

2. Tip: Firefox Users: The tab "Storage" might help you
Chrome Users: The tab "Application" might help you
