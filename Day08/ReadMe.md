### Application for Employee Information

##Build application with maven
mvn clean install

# Run Application with maven

mvn spring-boot:run

# Verify application Health
for windows

curl -L "http://localhost:8080/actuator/health"

# Create Employee
curl -L 'http://localhost:8080/employee/create/employee' \
--header 'Content-Type: application/json' \
--data '{
"id":"1",
"name": "emp1",
"age":25
}'
# for windows
curl -L -X POST "http://localhost:8080/employee/create/employee" -H "Content-Type: application/json" --data "{\"id\":1, \"name\":\"emp1\", \"age\":25}"

# Read All Employee Data

curl -L "http://localhost:8080/employee/get/all/employee"

# Update Employee Data

curl -L -X PUT "http://localhost:8080/employee/update/employee?id=1&age=22"

# Delete Employee Data


curl -L -X DELETE "http://localhost:8080/employee/delete/employee?id=2"