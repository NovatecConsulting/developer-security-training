# API06: Mass Assignment

Binding client provided data (e.g., JSON) to data models, without proper properties filtering based on an allowlist, usually leads to Mass Assignment. Either guessing objects properties, exploring other API endpoints, reading the documentation, or providing additional object properties in request payloads, allows attackers to modify object properties they are not supposed to.

Objects in modern applications might contain many properties. Some of these properties should be updated directly by the client (e.g., user.first_name or user.address) and some of them should not (e.g., user.is_vip flag).

An API endpoint is vulnerable if it automatically converts client parameters into internal object properties, without considering the sensitivity and the exposure level of these properties. This could allow an attacker to update object properties that they should not have access to.

Examples for sensitive properties:

* Permission-related properties: user.is_admin, user.is_vip should only be set by admins.
* Process-dependent properties: user.cash should only be set internally after payment verification.
* Internal properties: article.created_time should only be set internally by the application.

## How To Prevent

* If possible, avoid using functions that automatically bind a client’s input into code variables or internal objects.
* Whitelist only the properties that should be updated by the client.
* Use built-in features to blacklist properties that should not be accessed by clients.
* If applicable, explicitly define and enforce schemas for the input data payloads.