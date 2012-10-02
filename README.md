registration
======

Example of usage: JPA, JAXB, Spring MVC/ORM/OXM, JSR-303 validations, ExtJS, JPA/Hibernate integration tests and Selenium integration tests (maven)

Assignment requirements	
-------

Imagine that you are part of a team that is creating a new library from scratch to capture user registration details and store them in a repository. 

The library is intended to be consumed by different front-end applications (including web, console or windows applications).
Requirements

*	We need to capture and the following user details:
**	Username
**	PostCode
**	Email Address
*	Please see the table below for the email business rules:

<table>
    <tr>
        <td>Domain</td>
        <td>Allowed Email Addresses</td>
    </tr>
    <tr>
        <td>com-en</td>
        <td>.org.uk, co.uk, .biz</td>
    </tr>
    <tr>
        <td>com-br</td>
        <td>.org.br, .info</td>
    </tr>
    <tr>
        <td>com-es</td>
        <td>.miapuesta-es, .vistabet</td>
    </tr>
</table>

*	The repository to store user data is an xml data store that will be replaced in the next 6 – 12 months by a database.  Therefore we should be able to seamlessly switch from one data source to another at some point in the future.  Please take this into account when designing the solution.


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
