# API08: Injection

Injection flaws, such as SQL, NoSQL, Command Injection, etc., occur when untrusted data is sent to an interpreter as part of a command or query. The attacker’s malicious data can trick the interpreter into executing unintended commands or accessing data without proper authorization.

The API is vulnerable to injection flaws if:

* Client-supplied data is not validated, filtered, or sanitized by the API.
* Client-supplied data is directly used or concatenated to SQL/NoSQL/LDAP queries, OS commands, XML parsers, and Object Relational Mapping (ORM)/Object Document Mapper (ODM).
* Data coming from external systems (e.g., integrated systems) is not validated, filtered, or sanitized by the API.

## How To Prevent

Preventing injection requires keeping data separate from commands and queries.

* Perform data validation using a single, trustworthy, and actively maintained library.
* Validate, filter, and sanitize all client-provided data, or other data coming from integrated systems.
* Special characters should be escaped using the specific syntax for the target interpreter.
* Prefer a safe API that provides a parameterized interface.
* Always limit the number of returned records to prevent mass disclosure in case of injection.
* Validate incoming data using sufficient filters to only allow valid values for each input parameter.
* Define data types and strict patterns for all string parameters.