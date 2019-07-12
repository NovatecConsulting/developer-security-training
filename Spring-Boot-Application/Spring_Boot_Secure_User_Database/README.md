# Spring Boot Secure User Database



## SonarQube

To start the SonarQube docker container just use this command:

```
docker run --name sonarqube -p 9000:9000 -v /home/afa/development/depcheck:/opt/sonarqube/extensions sonarqube
```

After this you should be able to log into SonarQube (http://localhost:9000) using
the credentials admin/admin.

After successful login add the analyze permission to this user by
navigating to _Administration/Global Permissions_.

