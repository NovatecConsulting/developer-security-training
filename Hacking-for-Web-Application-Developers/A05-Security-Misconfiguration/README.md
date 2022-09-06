# A05: Security Misconfiguration
 
* [Challenge 7.1: Deprecated Interface](#challenge-71-Deprecated-Interface)
   * [Tips:](#tips)
* [Challenge 7.2: Error Handling](#challenge-72-Error-Handling)
   * [Tips:](#tips-1)

Security misconfiguration is usually a lack of hardening of the system or service, such as:
- Change the default passwords / accounts;
- Shutting down unnecessary service;
- Very informative error messages for users;
- New security functions received during update and not configured;
- Obsolete software;
 
## Challenge 7.1: Deprecated Interface
The old B2B interface was renewed and not all components were removed properly.
No attack or exploit is needed.
 
### Tips:
 
1. **Tip:** Log in as any user and go for **Contact Us**.
2. **Tip:** Use Devtools to find it in Code.
 
## Challenge 7.2: Error Handling
Trigger an error that is not handled correctly.
 
### Tips:
 
1. **Tip:** There are more than one possibility to trigger such Error.
2. **Tip:** Try to submit bad input to forms.
3. **Tip:** Try to manipulate the URL path and its parameters.
 
**Hint:** Don't forget to open your Javascript console.