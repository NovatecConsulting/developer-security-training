# A04: Insecure Design

**Insecure design** is a broad category representing different weaknesses, expressed as *missing or ineffective control design*. Insecure design is not the source for all other Top 10 risk categories. There is a difference between insecure design and insecure implementation. We differentiate between design flaws and implementation defects for a reason, they have different root causes and remediation.

A secure design can still have implementation defects leading to vulnerabilities that may be exploited. 

An insecure design cannot be fixed by a perfect implementation as by definition, needed security controls were never created to defend against specific attacks. One of the factors that contribute to insecure design is the lack of business risk profiling inherent in the software or system being developed, and thus the failure to determine what level of security design is required.

This includes the following topics:

* Establish and use a secure development lifecycle with AppSec professionals to help evaluate and design security and privacy-related controls
* Establish and use a library of [secure design patterns](https://patchstack.com/articles/security-design-principles-owasp/) or paved road ready to use components
* Use [threat modeling](https://www.threatmodelingmanifesto.org/) for critical authentication, access control, business logic, and key flows
* Integrate security language and controls into user stories
* Integrate plausibility checks at each tier of your application (from frontend to backend)
* Write [unit and integration tests](https://martinfowler.com/articles/practical-test-pyramid.html) to validate that all critical flows are resistant to the threat model. 
* Compile use-cases and [misuse-cases](https://cheatsheetseries.owasp.org/cheatsheets/Abuse_Case_Cheat_Sheet.html) for each tier of your application.
* Segregate tier layers on the system and network layers depending on the exposure and protection needs
* Segregate tenants robustly by design throughout all tiers
* Limit resource consumption by user or service

## Challenges

There are no challenges for **Insecure Design**.