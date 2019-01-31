# Spring Boot Secure User Database
**Spring Boot Secure User Database** is a Spring Boot application that shows you the implementation of common functions in web applications like a user registration, a user login or the protection of sensitive content from unauthorized access.

## Setup
1. Clone this repository: `git clone git@github.com:nt-ca-aqe/thesis-ahs.git`
2. Install MySQL: `sudo apt-get install mysql-server`
3. Start MySQL by entering the following commands:
`su`
`mysql`
4. Create a new mysql user to connect with the Spring Boot application by entering the following commands
`CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'springpassword';`
`GRANT ALL PRIVILEGES ON * . * TO 'springuser'@'localhost';`
`FLUSH PRIVILEGES;`
5. Paste the entire content from the file `initialization.sql` to create the database and the tables for the Spring Boot application.

7. Browse to http://localhost:8090
