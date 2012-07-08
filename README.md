registration
======

Example of usage: JPA, JAXB, Spring MVC/ORM/OXM, JSR-303 validations, ExtJS, JPA/Hibernate integration tests and Selenium integration tests (maven)

Info
-------

### registration-api

Common library to capture user registration details and store them in a repository

* XML (JAXB) repository implementation
* DB (JPA) repository implementation
* JSR-303 validations
* Spring context ORM/OXM
* JPA/Hibernate integration tests (hibernate3-maven-plugin)

### registration-webapp

Web application to show the use of registration-api

* Spring MVC
* Sencha ExtJS 
* Selenium (OpenQA) integration tests

Build and run
--------------

Test, build and install the registration-api library

    cd registration-api
    mvn clean install
    
Test, build and install the registration-webapp application

    cd registration-webapp
    mvn clean install
    
Run the registration-webapp application

    cd registration-webapp
    mvn jetty:run	

Access to the deployed application [localhost:8080/registration-webapp/](http://localhost:8080/registration-webapp/)
