# snippetchallenge
snippet coding challenge

### Application Structure

- Files must be located under `/src/main/java` to be picked up by Spring
- The source code is located in 
`src/main/java/com/webspoon/coding/challange/`
- The project assumes `com.webspoon.coding.challange.WebSpoonCodingChallengeApplication` is the Spring Boot Application. 

### Running the app

Press the "Run" button

-- OR -- 

From the Terminal in repl.it, run:

```
mvn clean package

java -jar target/WebSpoonCodingChallenge-0.0.1-SNAPSHOT.jar
```

A subwindow displaying a browser will appear, showing you the output. You may copy the URL and open it in a new browser tab to change the URL, e.g. adding `/greeting` to the end of the URL for the sample app will display the "Hello World" JSON.

### Assumptions

l chose to use ArrayList save the snnipet object, due to the time contraint, Model view Controller is my architecture and the usage of dependency injection


### Endpoints

The base project has three endpoints you can build on. They are all defined in the `SnippetController`:

- `/` - a "Welcome to the Spring Boot Application Starter!" default page 
- `GET /snippet` - a GET endpoint  String parameter and returns a JSON `Snippet` object
- `POST /snnippet` - a POST endpoint that takes a JSON body of the `Person` object with a name, and returns a JSON `Snippet` object


# To store snippet, use this payload
local setup running -- http://localhost:8081/snippet
repl
POST https://snippetchallenge.mosesone.repl.co/snippet
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
GET https://snippetchallenge.mosesone.repl.co/snippet


# To Edit and get extra 30 second whether u specify expire in or not

use this payload
PUT https://snippetchallenge.mosesone.repl.co/snippet
}
  "name": "recipe",
 // "expires_in": 30, // you can remove it or leave
  "snippet": "1 apple",
  "password": "1234"
}

