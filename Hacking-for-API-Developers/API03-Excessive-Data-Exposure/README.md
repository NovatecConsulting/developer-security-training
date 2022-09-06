# API03: Excessive Data Exposure

Looking forward to generic implementations, developers tend to expose all object properties without considering their individual sensitivity, relying on clients to perform the data filtering before displaying it to the user.

Exploitation of Excessive Data Exposure is simple, and is usually performed by sniffing the traffic to analyze the API responses, looking for sensitive data exposure that should not be returned to the user.
The API returns sensitive data to the client by design. This data is usually filtered on the client side before being presented to the user.

## How To Prevent

* Never rely on the client side to filter sensitive data.
* Review the responses from the API to make sure they contain only legitimate data.
* Backend engineers should always ask themselves "who is the consumer of the data?" before exposing a new API endpoint.
* Avoid using generic methods such as to_json() and to_string(). Instead, cherry-pick specific properties you really want to return
* Classify sensitive and personally identifiable information (PII) that your application stores and works with, reviewing all API calls returning such information to see if these responses pose a security issue.
* Implement a schema-based response validation mechanism as an extra layer of security. As part of this mechanism define and enforce data returned by all API methods, including errors.