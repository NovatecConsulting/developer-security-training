# API07: Security Misconfiguration

Security misconfiguration is commonly a result of unsecure default configurations, incomplete or ad-hoc configurations, open cloud storage, misconfigured HTTP headers, unnecessary HTTP methods, permissive Cross-Origin resource sharing (CORS), and verbose error messages containing sensitive information.

The API might be vulnerable if:

* Appropriate security hardening is missing across any part of the application stack, or if it has improperly configured permissions on cloud services.
* The latest security patches are missing, or the systems are out of date.
* Unnecessary features are enabled (e.g., HTTP verbs).
* Transport Layer Security (TLS) is missing.
* Security directives are not sent to clients (e.g., [Security Headers](https://owasp.org/www-project-secure-headers/#div-headers)).
* A Cross-Origin Resource Sharing (CORS) policy is missing or improperly set.
* Error messages include stack traces, or other sensitive information is exposed.

## How To Prevent

The API life cycle should include:

* A repeatable hardening process leading to fast and easy deployment of a properly locked down environment.
* A task to review and update configurations across the entire API stack. The review should include: orchestration files, API components, and cloud services (e.g., S3 bucket permissions).
* A secure communication channel for all API interactions access to static assets (e.g., images).
* An automated process to continuously assess the effectiveness of the configuration and settings in all environments.

Further Requirements:

* To prevent exception traces and other valuable information from being sent back to attackers, if applicable, define and enforce all API response payload schemas including error responses.
* Ensure API can only be accessed by the specified HTTP verbs. All other HTTP verbs should be disabled (e.g. HEAD).
* APIs expecting to be accessed from browser-based clients (e.g., WebApp front-end) should implement a proper Cross-Origin Resource Sharing (CORS) policy.
