# snippetchallenge
snippet coding challenge

Apology, l could not run it on reple. 

l have tried means on how to upload the project to repl , it seems not working.

To start the application

change direectory to the webspooncoding challenge directory

Then mvn spring-boot:run to start the application

This is snippet challenge that perform CRUD operation 

# To store snippet, use this payload
POST http://localhost:8081/snippet
{
  "name": "recipe",
  "expires_in": 30,
  "snippet": "1 apple",
  "password": "1234"
}

Response
{
    "name": "recipe",
    "expires_at": "2021-01-14T16:49:00.246+01:00",
    "snippetString": "1 apple",
    "url": "http://localhost:8081/snippet",
    "password": "1234"
}


# To Get the list of snippet
GET http://localhost:8081/snippet


# To Edit and get extra 30 second whether u specify expire in or not

use this payload
}
  "name": "recipe",
 // "expires_in": 30, // you can remove it or leave
  "snippet": "1 apple",
  "password": "1234"
}