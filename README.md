# Viermietet

# Task 1: Doman Modelling 
Repository name: domain-<id> 

Please create the domain model for the following use cases: 
1) A landlord can rent out a separate apartment, the whole building or several apartments to another party. 
2) A landlord can sign a rental contract with one or multiple tenants. 
3) One tenant can rent multiple apartments from the same landlord. 
4) One tenant can rent multiple apartments simultaneously. 
5) A landlord can also be a tenant of another landlord.

[Solution diagram model] 
https://drive.google.com/file/d/1-RZ0elx24QWJj4aiem-ttnd2w698TPt4/view?usp=sharing 

# Task 2: Architecture & Coding 

I have already some projects done in the past with similar complexity like below or you can check my open repositories in Github 

- https://github.com/Boburmirzo/axiom-mobile-handset
- https://github.com/Boburmirzo/teletronics
- https://github.com/Boburmirzo/monese-money-transfer

### Prerequisites

```
Maven
Java 1.8
IDEA
```
External libraries : codehaus.jackson, spring-boot. Full specification can be found in pom file.



### Installing

mvn clean install

Main class App.java.

### Running
You can run the application from console or IDE of your choise with:

mvn spring-boot:run

### Testing
TDD has been used during development

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Bobur Umurzokov**

## Asumptions
Device Id and Apartment Id are unique.


