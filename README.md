# Challenge Backend Final - **Java**
## Spring Boot (API) Pre-Aceleración - Alkemy 


### Target

    
>The objective of this challenge is to develop an API using Java SpringBoot and SpringSecurity, 
following the REST pattern, that allows to know and modify the catalog of characters, movies and genres of Disney movies.

### Requirements

- Java 11.

- Maven 3.

- MySQL 8.

***

### Setup Steps


**1. Clone repository.**
```bash
  git clone https://github.com/denisdimarco/Pre-Aceleracion-JAVA-Denis_Di_Marco.git
```
    
**2. Create DataBase in MySQL**

```mysql
    CREATE DATABASE disney;
```

**3. Change MySQL server username and password in application.properties file.**

+ Open `disney-api/src/main/resources/application.properties`


+ Change the username and password as you have configured your MySQL
    + `spring.datasource.username=root` 
    + `spring.datasource.password=root` 

**4. Setup Environment Variables in your IDE.**

+ Create an account on https://app.sendgrid.com and get your API Key.

+ Create an EMAIL_API_KEY in your IDEs environment variables.

+ Input your SendGrid API KEY:
    > EMAIL_API_KEY=yourkey
  
+ Open `disney-api/src/main/resources/application.properties` file
+ Change to your SendGrid registered email in `alkemy.disneyapi.email.sender=youremail@mail.com `
+ 
**5. Build and Run.**

The app will run at: http://localhost:8080/

***

**Postman Workspace:**

> https://www.postman.com/avionics-administrator-75630177/workspace/alkemy-challenge-disneyapi-workspace





