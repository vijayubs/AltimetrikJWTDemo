# AltimetrikJWTDemo

Restfull web-service with JWT security  . <br/>
Employee resource is exposed with the following endpoints ..<br/><br/>

<b>1</b>- /authenticate      - To authenticate with username and password , JWT tocken will be return with 5 minute validity <br/>
<b>2</b>- /employees         - POST - Request to post a request with JWT token in order to create the employee .<br/>
<b>3</b>- /employees         - GET -  Request to get the list of all employees .<br/>
<b>4</b>- /employees/{id}    - GET -  Request to get the specific employee as per the employee ID .<br/>
<b>5</b>- /employees/{id}    - PUT -  Request to Update a specific employee .<br/>
<b>6</b>- /employees/{id}    - DELETE- Request to Delete a specific employee according to employeeID .<br/>

Swagger URL - http://localhost:8080/swagger-ui.html#/employee-controller

