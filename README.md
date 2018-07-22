Create RESTful API
=====

This demo shows how to create RESTful with GET/PUT/POST/DELETE method what accepts JSON.

Using Jersey 2 API + Tomcat + JAVA
=====

**Pre-requisite**
1. Install Tomcat plugin in Eclipse
http://tomcatplugin.sf.net/update
2. Download Tomcat version 8
3. Download Jersey .jars

**Setup**

1. Download Tomcat version 8 from https://tomcat.apache.org/download-80.cgi#8.5.31 and unzip
2. Add Tomcat Server path in Eclipse --> Preference --> Server --> RunTime Environment --> Add --> Apache Tomcat v8.5 --> browse --> ~/Documents/tomcat/apache-tomcat-8.5.31 --> Finish
3. Start Tomcat, it will run successfully  
4. Create "Dynamic Web Project" in Eclipse with name "CreateRESTFulService" & make sure to select "Generate Web.xml deployment descriptor"
4. Download Jersey from https://jersey.github.io/download.html --> "Jersey JAX-RS 2.1 RI bundle", unzip it
5. Add Jersey to Eclipse Project, navigate to Eclipse Project WebContent-->Web-INF--> lib --> <place all jersey jars>
6. Under Java Resource/src create package "package1" and java class "FirstRest"
7. Add code present in FirstRest.Java in FirstRest
8. web.xml - add code present in web.xml
Run project as "Run on Server"

**Test**
User can send following Request, Postman can be used to send request

	http://localhost:8080/CreateRESTFulService/employee/list — to get all employees list
	http://localhost:8080/CreateRESTFulService/employee/list/id — to get specific id from employee list
	http://localhost:8080/CreateRESTFulService/employee/add — to add an employee to employee list
	http://localhost:8080/CreateRESTFulService/employee/delete/id — to delete an employee
	http://localhost:8080/CreateRESTFulService/employee/update/id — to update an employee info
	
	where id is a number

***Examples :***

**GET Request Example**
*All employees*
URL : http://localhost:8080/CreateRESTFulService/employee/list

Output :
```
[
    {
        "firstName": "first111",
        "id": 1,
        "lastName": "last11111111"
    },
    {
        "firstName": "first2",
        "id": 2,
        "lastName": "last2"
    },
    {
        "firstName": "first3",
        "id": 3,
        "lastName": "last3"
    },
    {
        "firstName": "first4",
        "id": 4,
        "lastName": "last4"
    },
    {
        "firstName": "first5",
        "id": 5,
        "lastName": "last5"
    }
]
```

**GET Request Example**
**One employees*
URL : http://localhost:8080/CreateRESTFulService/employee/list/1

Output :
```
[
    {
        "firstName": "first111",
        "id": 1,
        "lastName": "last11111111"
    }
]
```

**PUT request Example**
URL : http://localhost:8080/CreateRESTFulService/rest/employee/update/1

```
Output :
{
    "message": "Employee Updated"
}
```

**POST request Example**
URL : http://localhost:8080/CreateRESTFulService/rest/employee/add

Input :
```
{
        "firstName": "first7",
        "id": 7,
        "lastName": "last7"
}
```
Output :
```
{
    "message": "Employee Added"
}
```
**Delete request Example**
URL : http://localhost:8080/CreateRESTFulService/rest/employee/delete/1

Output :
```
{
    "message": "employee deleted"
}
```


***REST API Response http Status code following methods:***

***GET**
200 (OK)
404 (NOT FOUND)
400 (BAD REQUEST)

***POST***
201 (Created) --> resource/json is return
200 (OK) or 204 (No Content) --> when no resource is return


**Note : Many times, the action performed by the POST method might not result in a resource that can be identified by a URI. In this case, either HTTP response code 200 (OK) or 204 (No Content) is the appropriate response status.**

***PUT***
201 (Created) - If a new resource has been created by the PUT API,
200 (OK) or 204 (No Content)  - if an existing resource is modified, either the 200 (OK) or 204 (No Content)

***DELTE***
200 (OK) if the response includes an entity describing the status
202 (Accepted) if the action has been queued
204 (No Content) if the action has been performed but the response does not include an entity.

***Common HTTP Status code***
2xx --> Success 
3xx --> multiple request
4xx --> Client side error
5xx --> Server side error
