Create & Host RESTful API
=====

**This project demonstrates following**

1) how to create RESTful service.
2) how to create GET/PUT/POST/DELETE methods,
3) methods Accepts JSON
4) export project as .war file and run under tomcat.
5) project complied .war file available under ProjectOutputWar/CreateRESTFulService.war

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
6. web.xml - add code present in web.xml
Run project as "Run on Server"
7. Export project as .war file
8. Place ProjectOutputWar/CreateRESTFulService.war under tomcat webapps folder and start tomcat server.

**Test**

To test this project place CreateRESTFulService.war from ProjectOutputWar/CreateRESTFulService.war to under tomcat webapps folder and start tomcat.

Try following request using Postman with Header value *Content-type : application/json*

*Note: this will not work over browser as this is only supporting JSON, and no query parameter is set to take input for different formats like plain text, xml etc*
	
	http://localhost:8080/CreateRESTFulService/rest/employee/list — to get all employees list
	
	http://localhost:8080/CreateRESTFulService/rest/employee/list/id — to get specific id from employee list
	
	http://localhost:8080/CreateRESTFulService/rest/employee/add — to add an employee to employee list
	
	http://localhost:8080/CreateRESTFulService/rest/employee/delete/id — to delete an employee
	
	http://localhost:8080/CreateRESTFulService/rest/employee/update/id — to update an employee info
	

***Examples :***

**GET**

*All employees*

URL : http://localhost:8080/CreateRESTFulService/rest/employee/list

Output :

```
[
    {
        "firstName": "Anne",
        "id": 1001,
        "lastName": "Brown"
    },
    {
        "firstName": "Ben",
        "id": 1002,
        "lastName": "Miller"
    },
    {
        "firstName": "Joe",
        "id": 1003,
        "lastName": "Johnson"
    },
    {
        "firstName": "Mike",
        "id": 1004,
        "lastName": "Smith"
    },
    {
        "firstName": "Tom",
        "id": 1005,
        "lastName": "Williams"
    }
]
```

**GET**

**One employee**

URL : http://localhost:8080/CreateRESTFulService/rest/employee/list/1002

Output :

```
[
    {
        "firstName": "Ben",
        "id": 1002,
        "lastName": "Miller"
    }
]
```

**PUT**

**Update employee**

URL : http://localhost:8080/CreateRESTFulService/rest/employee/update

Input 

```
{
    {
        "firstName": "Joe",
        "id": 1003,
        "lastName": "Lisa"
    }
}
```

Output :

```
{
    "message": "Employee Updated"
}
```

**POST**

**Add employee**

URL : http://localhost:8080/CreateRESTFulService/rest/employee/add

Input :

```
{
        "firstName": "Alex",
        "id": 1007,
        "lastName": "The Great"
}
```

Output :

```
{
    "message": "Employee Added"
}
```

**Add multiple employees**

URL : http://localhost:8080/CreateRESTFulService/rest/employee/addMultiple

Input :

```
[{
		"firstName": "Alex",
		"id": 1009,
		"lastName": "The Great"
	},
	{
		"firstName": "Alex",
		"id": 1010,
		"lastName": "The Great"
	}
]
```

Output :

```
{
    "message": "Multiple Employees Added"
}
```

**Delete**

**Delete employee**

URL : http://localhost:8080/CreateRESTFulService/rest/employee/delete/1001

Output :

```
{
    "message": "employee deleted"
}
```

**Delete multiple employees**

URL : http://localhost:8080/CreateRESTFulService/rest/employee/deleteMultiple

Input :

```
[{
	"id": 1001
}, {
	"id": 1002
}]
```

Output :

```
[
    {
        "message": "ids : 1001 -- Employee Deleted"
    },
    {
        "message": "ids : 1002 -- Employee Deleted"
    }
]
```


***REST API Response http Status code following methods:***

***GET***

200 (OK)

404 (NOT FOUND)

400 (BAD REQUEST)

***POST***

201 (Created) --> resource/JSON is return

200 (OK) or 204 (No Content) --> when no resource is return


*Note : Many times, the action performed by the POST method might not result in a resource that can be identified by a URI. In this case, either HTTP response code 200 (OK) or 204 (No Content) is the appropriate response status.*

***PUT***

201 (Created) - If a new resource has been created by the PUT API,

200 (OK) or 204 (No Content)  - if an existing resource is modified, either the 200 (OK) or 204 (No Content)

***DELETE***

200 (OK) if the response includes an entity describing the status

202 (Accepted) if the action has been queued

204 (No Content) if the action has been performed but the response does not include an entity.

***Common HTTP Status code***

2xx --> Success 

3xx --> multiple request

4xx --> Client side error

5xx --> Server side error

