# A02: Cryptographic Failures

The first thing is to determine the protection needs of data in transit and at rest. For example, passwords, credit card numbers, health records, personal information, and business secrets require extra protection, mainly if that data falls under privacy laws, e.g., EU's [General Data Protection Regulation (GDPR)](https://gdpr.eu/), or regulations, e.g., financial data protection such as [PCI Data Security Standard (PCI DSS)](https://www.pcisecuritystandards.org/):

* Is any data transmitted in clear text? This concerns protocols such as HTTP, SMTP, FTP also using TLS upgrades like STARTTLS. External internet traffic is hazardous. Verify all internal traffic, e.g., between load balancers, web servers, or back-end systems.
* Are any old or weak cryptographic algorithms or protocols used either by default or in older code?
* Are default crypto keys in use, weak crypto keys generated or re-used, or is proper key management or rotation missing? Are crypto keys checked into source code repositories?
* Is encryption not enforced, e.g., are any HTTP headers (browser) security directives or headers missing?
* Is the received server certificate and the trust chain properly validated?
* Are initialization vectors ignored, reused, or not generated sufficiently secure for the cryptographic mode of operation? Is an insecure mode of operation such as ECB in use? Is encryption used when authenticated encryption is more appropriate?
* Are passwords being used as cryptographic keys in absence of a password base key derivation function?
* Is randomness used for cryptographic purposes that was not designed to meet cryptographic requirements? Even if the correct function is chosen, does it need to be seeded by the developer, and if not, has the developer over-written the strong seeding functionality built into it with a seed that lacks sufficient entropy/unpredictability?
* Are deprecated hash functions such as MD5 or SHA1 in use, or are non-cryptographic hash functions used when cryptographic hash functions are needed?
* Are deprecated cryptographic padding methods such as PKCS number 1 v1.5 in use?
* Are cryptographic error messages or side channel information exploitable, for example in the form of padding oracle attacks?

## Table of Challenges

   * [Challenge 1: Find and open a confidential document](#challenge-1-find-and-open-a-confidential-document)
      * [Tips:](#tips)

**HINT:** [Install Postman](https://www.getpostman.com/apps) and [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads) if you haven't done yet.

## Challenges

### Challenge 1: Find and open a confidential document

#### Tips:

1. **Tip:** A scan of the **OWASP Juice Shop** by [OWASP ZAP](https://github.com/zaproxy/zaproxy/wiki/Downloads) might help you.

2. **Tip:** Search after hidden links to areas you haven't seen before (with **OWASP ZAP** or in the user interface).

3. **Tip:** Inspect the `About Us` section.
