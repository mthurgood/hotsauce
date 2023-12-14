# hotsauce
Backend system for social hot sauce application
# Maven
	mvn clean package

# Docker
	docker-compose up
	docker compose up -d
	docker compose up -d java_db

# Users
## Get List of Users (GET)
GET localhost:8080/api/users

	curl --location 'localhost:8080/api/users'

## Create User (POST)
	curl --location 'localhost:8080/api/users' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"username": "user1",
		"password": "mypassword",
		"email": "user1@gmail.com",
		"firstName": "User",
		"lastName": "Name",
		"userStatus": "created"
	}'

## Update User (PUT)
	curl --location --request PUT 'localhost:8080/api/users/2' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"username": "user2",
		"password": "mypassword",
		"email": "user2@gmail.com",
		"firstName": "User",
		"lastName": "Name2",
		"userStatus": "created"
	}'
# Companies
## Get List of Companies (GET)
GET localhost:8080/api/companies

    curl --location 'localhost:8080/api/companies'

## Create Company (POST)
    curl --location --request POST 'localhost:8080/api/companies' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "name": "Company 1",
        "description": "A Description",
        "location": "New York",
        "website": "www.company1.com",
        "image": ""
    }'

## Update Company (PUT)
    curl --location --request PUT 'localhost:8080/api/companies/2' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "name": "Company 1",
        "description": "A Description",
        "location": "New York",
        "website": "www.company1.com",
        "image": ""
    }'

## Delete Company (DELETE)
    curl --location --request DELETE 'localhost:8080/api/companies/2'

