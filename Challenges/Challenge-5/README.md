# Challenge Collection 5: Cross-Site scripting (XSS)

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
