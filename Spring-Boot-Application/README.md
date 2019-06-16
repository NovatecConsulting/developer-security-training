# Spring Boot Secure User Database
**Spring Boot Secure User Database** is a Spring Boot application that shows you the implementation of common functions in web applications like a user registration, a user login or the protection of sensitive content from unauthorized access.

## System Requirements
* A Java SDK ([Setup for Linux](https://www.javahelps.com/2017/09/install-oracle-jdk-9-on-linux.html))
* Apache Maven ([Setup for Linux](https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html))

## Setup
1. Clone this repository: `git clone https://github.com/nt-ca-aqe/thesis-ahs.git`
2. Install MySQL: `sudo apt-get install mysql-server`
3. Start MySQL by entering the following commands:
`su`
`mysql`
4. Create a new mysql user to connect with the Spring Boot application by entering the following commands  
`CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'springpassword';`  
`GRANT ALL PRIVILEGES ON * . * TO 'springuser'@'localhost';`  
`FLUSH PRIVILEGES;`
5. Paste the entire content from the file `initialization.sql` to create the database and the tables for the Spring Boot application.

6. Open terminal in folder `Spring_Boot_Secure_User_Database` and enter the following command: `mvn spring-boot:run`

7. Browse to http://localhost:8090
