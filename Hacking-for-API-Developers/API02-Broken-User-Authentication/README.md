# API02: Broken User Authentication

## Description

Authentication mechanisms are often implemented incorrectly, allowing attackers to compromise authentication tokens or to exploit implementation flaws to assume other user’s identities temporarily or permanently. Compromising a system’s ability to identify the client/user, compromises API security overall.
Authentication in APIs is a complex and confusing mechanism. Software and security engineers might have misconceptions about what are the boundaries of authentication and how to implement it correctly.

## Vulnerability

An API is vulnerable if it:

* Permits [credential stuffing](https://owasp.org/www-community/attacks/Credential_stuffing) whereby the attacker has a list of valid usernames and passwords.
* Permits attackers to perform a brute force attack on the same user account, without presenting captcha/account lockout mechanism.
* Permits [weak passwords](https://pages.nist.gov/800-63-3/sp800-63b.html#appA).
* Sends sensitive authentication details, such as auth tokens and passwords in the URL.
* Doesn’t validate the authenticity of tokens.
* Accepts unsigned/weakly signed JWT tokens ("alg":"none")/doesn’t validate their expiration date.
* Uses plain text, non-encrypted, or weakly hashed passwords.
* Uses weak encryption keys.

## Forge JWT

To make it more easy to play around with JSON web tokens (JWT) the `jwt tool` can be used.
Look at <https://github.com/ticarpi/jwt_tool> for more information.

To install it you need to have python 3 installed and then just follow these steps:

```bash
git clone https://github.com/ticarpi/jwt_tool
python3 -m pip install termcolor cprint pycryptodomex requests
```

To use it:

1. Change into `jwt_tool` directory
2. Call it using `python3 jwt_tool.py -h` (with getting help usage)

### Brute force attack on JWT signature secret key

To perform a brute force attack to retrieve the secret key for creating a valid signature for a JWT you can use the provided `crack.sh` script using one of the included word lists.

### Exploit JWT

You can also try to change JWT to try to exploit the authentication using the provided èxploit.sh` script.
