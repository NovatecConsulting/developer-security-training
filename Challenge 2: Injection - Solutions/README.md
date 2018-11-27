# Challenge Collection 2: Injection - Solutions

## Challenge 2.1: Log in as administrator

### Variant 1: Causing an internal server error by inserting invalid input

Provoke an error by crashing the application with the input `admin@juice-sh.op'` and any password.  

![2_1_1](screenshots/solution2_1_1.png)  

There occurs an error `[object Object]`. If you look at the console, you will recieve more information  
![2_1_2](screenshots/solution2_1_2.png)  

There you can recognize the underlying NoSQL-Query in the row `sql`: `SELECT * FROM Users WHERE email = 'admin@juice-sh.op'' AND password = '202cb962ac59075b964b07152d234b70'`. As a consequence of the two apostrophes following the email, the statement now is corrupted. The rest of the statement after the email can be commented out with two hyphen `--`. So, the password won't be compared with the entry in the database.  
![2_1_3](screenshots/solution2_1_3.png)  
With `admin@juice-sh.op'--` as input and any password, you can access the administrator's account.

### Variant 2: Scanning the juice shop with OWASP ZAP

[Install OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads).  
Open OWASP ZAP. In the field `URL to attack`, fill in the URL of Juice Shop and click the `Launch Browser`-Button.  
![2_1_4](screenshots/solution2_1_4.png)  

In this browser, you go to `http://localhost:3000/#/login` and attempt a login with the email of the admin. Type `admin@juice-sh.op` in the email field, a random input in the password field and click the `Log in` Button  
![2_1_5](screenshots/solution2_1_5.png)  
In this way, you cause a POST call on the REST API. Go back to OWASP ZAP and expand the `http://localhost:3000` folder in the `Sites` tab:  
![2_1_6](screenshots/solution2_1_6.png)  
You will see, that the last POST call is monitored there. Right click the POST call and choose `Attack` --> `Active Scan..`:  
![2_1_7](screenshots/solution2_1_7.png)  
Confirm the dialog with `Start Scan`:  
![2_1_8](screenshots/solution2_1_8.png)  

OWASP ZAP attempts to log in the application by changing several parameters in the POST call that you made before with your login attempt. In this case, the password has been replaced:  
![2_1_10](screenshots/solution2_1_10.png)  
As you can see, there are numerous attempts with the result `Unauthorized`. By sorting the `Code` or `Reason` column, a few calls with status `OK` are shown.  
![2_1_11](screenshots/solution2_1_11.png)  
You see the parameters that lead to a successful login: `admin@juice-sh.op' AND '1'='1' --` as email input and `123` as password input.


## Challenge 2.2: Modify a product review

Open the web development tool and select the tab `Console`.
Open the product information for `Apple Juice (1000 ml)`. You will receive the GET call `http://localhost:3000/rest/product/1/reviews`. Select the tab `Response` (Firefox) of the GET call to see the given parameters:
![2_2_1](screenshots/solution2_2_1.png)  

Open Postman and type `http://localhost:3000/rest/product/reviews` as link (note that you have to remove the `1` from the original GET call).
As you found out from the console, the id of the message you want to attack in this case is `JregNHgrt7v6Ttpzv`. So, this must appear in your body, as this is the only message you want to modify. Your body should look like this:
`{ "id": "JregNHgrt7v6Ttpzv", "message": "Apple Juice has been hacked!"}`. Check if you have chosen `JSON (application/json)` as type:

![2_2_2](screenshots/solution2_2_2.png)  
`Send` this as a PATCH call.
Opening the product information again shows the wanted comment:
![2_2_3](screenshots/solution2_2_3.png)  

## Challenge 2.3: Modify multiple product reviews at once

Similar to [Challenge 2.2](), you need to insert `http://localhost:3000/rest/product/reviews` in Postman.
You have to replace the old input for the `id` with `{ "$ne": "" }`, because `ne` is the `not equal` operator. As you want to update **all** product reviews, `ne=""` will match every time because there is no id with an empty string.
Adjust the message to `Juice Shop has been hacked!`, make sure you have selected `JSON (application/json)` and `Send` the PATCH call:

![2_3_1](screenshots/solution2_3_1.png)  

A look at several products shows that reviews from different users has changed to the wanted message:  

![2_3_2](screenshots/solution2_3_2.png)  
![2_3_3](screenshots/solution2_3_3.png)  


## Challenge 2.4: Cause the server of the juice shop to sleep for 2 seconds

Open any product information while observing the console of the web development tool. You see the GET call `http://localhost:3000/rest/product/1/reviews`, which holds an opportunity for injecting the sleep function:  

![2_4_1](screenshots/solution2_4_1.png)  

Call `http://localhost:3000/rest/product/sleep(2000)/reviews`. You see that the browser will load longer before showing this JSON response:  
![2_4_2](screenshots/solution2_4_2.png)
