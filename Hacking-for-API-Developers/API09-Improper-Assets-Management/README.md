# API09: Improper Assets Management

APIs tend to expose more endpoints than traditional web applications, making proper and updated documentation highly important. Proper hosts and deployed API versions inventory also play an important role to mitigate issues such as deprecated API versions and exposed debug endpoints.

The API might be vulnerable if:

* The purpose of an API host is unclear, and there are no explicit answers to the following questions:
* Which environment is the API running in (e.g., production, staging, test, development)?
* Who should have network access to the API (e.g., public, internal, partners)?
* Which API version is running?
* What data is gathered and processed by the API (e.g., PII)?
* What's the data flow?
* There is no documentation, or the existing documentation is not updated.
* There is no retirement plan for each API version.
* Hosts inventory is missing or outdated.
* Integrated services inventory, either first- or third-party, is missing or outdated.
* Old or previous API versions are running unpatched.

## How To Prevent

* Inventory all API hosts and document important aspects of each one of them, focusing on the API environment (e.g., production, staging, test, development), who should have network access to the host (e.g., public, internal, partners) and the API version.
* Inventory integrated services and document important aspects such as their role in the system, what data is exchanged (data flow), and its sensitivity.
* Document all aspects of your API such as authentication, errors, redirects, rate limiting, cross-origin resource sharing (CORS) policy and endpoints, including their parameters, requests, and responses.
* Generate documentation automatically by adopting open standards. Include the documentation build in your CI/CD pipeline.
* Make API documentation available to those authorized to use the API.
* Use external protection measures such as API security firewalls for all exposed versions of your APIs, not just for the current production version.
* Avoid using production data with non-production API deployments. If this is unavoidable, these endpoints should get the same security treatment as the production ones.
* When newer versions of APIs include security improvements, perform risk analysis to make the decision of the mitigation actions required for the older version: for example, whether it is possible to backport the improvements without breaking API compatibility or you need to take the older version out quickly and force all clients to move to the latest version.
