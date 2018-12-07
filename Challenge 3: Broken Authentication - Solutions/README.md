# Challenge Collection 3: Broken Authentication - Solutions

   * [Challenge 3.1: Brute-force attack](#challenge-31-brute-force-attack)
   * [Challenge 3.2: Create an administrator account](#challenge-32-create-an-administrator-account)
   * [Challenge 3.3: Take over the session of a previously logged in user](#challenge-33-take-over-the-session-of-a-previously-logged-in-user)
   * [Challenge 3.4: Change the password of the user account of Bender](#challenge-34-change-the-password-of-the-user-account-of-bender)
   * [Challenge 3.5: Log in with the user account of Bender](#challenge-35-log-in-with-the-user-account-of-bender)

## Challenge 3.1: Brute-force attack

[Install OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads).

Open OWASP ZAP. In the field `URL to attack`, fill in the URL of Juice Shop and click the `Launch Browser`-Button.  
![3_1_1](screenshots/solution3_1_1.png)  

In this browser, you go to http://localhost:3000/#/login and attempt a login with the email of the admin. Type `admin@juice-sh.op` in the email field, a random input in the password field and click the `Log in`-Button  
![3_1_2](screenshots/solution3_1_2.png)  

In this way, you cause a POST call on the REST API. Go back to OWASP ZAP and expand the `http://localhost:3000` folder in the `Sites` tab:  

![3_1_3](screenshots/solution3_1_3.png)  
You will see, that the last POST call is monitored there. Right click the POST call and choose `Attack` --> `Fuzz...`:  
![3_1_4](screenshots/solution3_1_4.png)  

In the window `Fuzzer`, mark the password (in this case `123`) that you have chosen for your login attempt as this is the parameter that should be replaced. In the area `Fuzz Locations:`, click on `Add...`:  
![3_1_5](screenshots/solution3_1_5.png)  

In the window "payloads", click again on `Add...`:  
![3_1_7](screenshots/solution3_1_7.png)  

In the window "Add Payload", change the `Type` to file, click at `Select...` and choose a wordlist from your local drive:  
![3_1_8](screenshots/solution3_1_8.png)  

For example, you can get the file `darkweb2017-top10000` from https://github.com/danielmiessler/SecLists/tree/master/Passwords:  
![3_1_9](screenshots/solution3_1_9.png)  


After adding the file, you can see a preview of the words in your textfile:  
![3_1_10](screenshots/solution3_1_10.png)  

Click on `Add` and confirm the `Payloads` window with `OK`.
Your `Fuzzer` window should look like this:  
![3_1_11](screenshots/solution3_1_11.png)  

Now, you are ready to click on `Start Fuzzer`.
While Fuzzering, you will receive lots of passwords that lead to the status `Unauthorized`:  
![3_1_12](screenshots/solution3_1_12.png)  

Sort after the column "Code" or `Reason` and you see a row with one `OK` result. The column `Payloads` presents the password for the email `admin@juice-sh.op`: `admin123`.  
![3_1_13](screenshots/solution3_1_13.png)

## Challenge 3.2: Create an administrator account

Install [Postman](https://www.getpostman.com/apps).  

Log in with your own account or with the admins account (described in challenges [2.1](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%202:%20Injection#challenge-21-log-in-as-administrator) and [3.1](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%203:%20Broken%20Authentication%20-%20Solutions#challenge-31-brute-force-attack)).
Browse to http://localhost:3000/#/administration, open the console of the web development tool and click on any eye icon next to the emails.  
![3_2_1_2](screenshots/solution3_2_1_2.png)  
In the console, you will see the GET-request `http://localhost:3000/api/Users/1` that reveals you an opportunity to interact with the API. Switch to tab `Response` to see the name of the parameters you have to pass:  
![3_2_1_1](screenshots/solution3_2_1_1.png)  
Open Postman. Fill in `http://localhost:3000/api/Users` (note, that you don't pass the id `1` in this case) as POST-request. Switch to tab `Body` and choose `JSON (application/json)`. There, you have to fill in something like `{"email": "newadmin@juice-sh.op", "password": "admin", "isAdmin": "true"}`. After sending this POST-request, your Postman window should look like this:  
![3_2_2](screenshots/solution3_2_2.png)

## Challenge 3.3: Take over the session of a previously logged in user

Make sure that the option `Persist Logs` is ticked in the console of the web development tool. So, you can browse through the Juice Shop without the need of having the web development tool open to capture the GET- and POST-requests.  
![3_3_1](screenshots/solution3_3_1.png)  

In this case, the admin account with the email the email `admin@juice-sh.op` is the previously logged in user. Log in with his credentials (described in challenges [2.1](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%202:%20Injection#challenge-21-log-in-as-administrator) and [3.1](https://github.com/nt-ca-aqe/thesis-ahs/tree/master/Challenge%203:%20Broken%20Authentication%20-%20Solutions#challenge-31-brute-force-attack)) and log out again.  
Log in with another account, for example your own account. In this case, the email of this account is `testuser@juice-sh.op`  
Open the console and extend a GET- or POST-request caused by the admin account. In this example, the POST call `http://localhost:3000/rest/user/login` has been expanded:  
![3_3_2](screenshots/solution3_3_2.png)  
In tab `Response`, the session token and is shown. Also, the row `umail` reveals that the session token belongs to the admin's account. Copy the session token and switch to tab `Storage` (Firefox) of the web development tool:

![3_3_3](screenshots/solution3_3_3.png)  
As you can see at the top, the currently active session is `testuser@juice-sh.op`. Now expand the section `Cookies` and click on `http://localhost:3000`. In the row `token`, replace the content of the column `Value` with the previously copied session token and reload the browser.

![3_3_4](screenshots/solution3_3_4.png)  
As you now see at the top, the session of `admin@juice-sh.op` has been restored without using the user credentials.


## Challenge 3.4: Change the password of the user account of Bender


## Challenge 3.5: Log in with the user account of Bender

