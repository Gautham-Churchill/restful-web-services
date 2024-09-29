# Learning SpringBoot from Udemy tutorial
[Course Link](https://www.udemy.com/course/spring-hibernate-tutorial/?couponCode=ACCAGE0923)

### Dev tool setup for community edition
- In Settings, go to `Build, Execution, Deployment`
- Go to `Compiler` and choose `Build project automatically`
- Now go to `Advanced Settings` and choose `Allow auto-make to start even if developed application is currently running` 

### Bean scopes
- `Singleton` - One bean shared across
- `Prototype` - New bean for every initialization
- `Request`
- `Session`
- `Application`
- `Websocket`

# Spring Data JPA

<p>

`spring.jpa.hibernate.ddl-auto` this property can be used to initialize database using JPA.

* **none** - disable ddl handling
* **create-drop** - will create and drop the ddl on server start and stop
* **create** - will create and override and previous data is there **(CAREFUL!)**
* **validate** - validate the schema and make no changes to the DB
* **update** - update the schema if needed
</p>

## Todo list
- Create CRUD for user details (with hashed pwd)
- Create users in custom user table using JPA (as shown in 159 lesson the udemy course)
