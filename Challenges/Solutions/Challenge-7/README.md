# Challenge Collection 7: Security Misconfiguration
 
* [Challenge 7.1: Deprecated Interface](#challenge-71-Deprecated Interface)
 
## Challenge 7.1: Deprecated Interface
1. log in as any user
2. go to **Contact Us** and in the menu go to **Complaint?**
3. when trying to upload a file, the message **Only PDF and Zip possible** appears. If you try to upload something else, you get an error message.
4. search DevTools in 'main.js' for the file upload rules. (Search for example zip or pdf)
5. the declaration for "xml" appears under 'allowedMimeType'
6. create an XML file and upload it.
7. the note appears and now check the DevTool.
8. in the Javascript Console you see 410 (Gone) and under "Network" you see a corresponding error message.
 
 
## Challenge 7.2: Error Handling
There are many ways to solve this challenge, like for example:
- Try to solve with " ' " (single quotation marks) and whatever as password.
- Visit http://localhost:3000/rest/qwertz
 
Further manipulation of URL path and parameters possible.