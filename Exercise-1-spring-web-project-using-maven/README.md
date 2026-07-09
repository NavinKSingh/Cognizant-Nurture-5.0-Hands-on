# spring-learn — Spring REST + JWT Hands-on (Spring Boot 3)

Complete implementation of all hands-on exercises from the 5 uploaded documents:

1. `1__spring-rest-handson.docx` — Spring Core: Maven project, XML bean config, logging, singleton/prototype scopes, country list
2. `2__spring-rest-handson.docx` — Spring REST: HelloController, CountryController (GET), MockMvc tests
3. `3__spring-rest-handson.docx` — Employee/Department REST services backed by XML config
4. `4__spring-rest-handson.docx` — POST/PUT/DELETE with validation, global exception handling
5. `5__JWT-handson.docx` — Spring Security + JWT authentication/authorization

## Important note: Spring Boot 3, not Spring Boot 2

Your tracking sheet (screenshot) labels this module **"Spring REST using Spring Boot 3"**, but
the hands-on documents were written against an older Spring Boot 2.x API
(`WebSecurityConfigurerAdapter`, `javax.validation`, `javax.servlet`, jjwt 0.9.0's old single-arg
API). Those APIs are **removed** in Spring Boot 3 / Spring Security 6. Every file below implements
the exact same behaviour the hands-on asks for, using the modern Spring Boot 3 equivalents:

| Old (hands-on doc, Boot 2) | New (this project, Boot 3) |
|---|---|
| `extends WebSecurityConfigurerAdapter` | `SecurityFilterChain` + `AuthenticationManager` `@Bean`s |
| `javax.validation.*` | `jakarta.validation.*` |
| `javax.servlet.*` | `jakarta.servlet.*` |
| `Jwts.parser().setSigningKey(String)` | `Jwts.parserBuilder().setSigningKey(Key)` (jjwt 0.11.5) |
| `HttpStatus status` param on `ResponseEntityExceptionHandler` overrides | `HttpStatusCode status` |

Every such change is called out with a code comment at the exact spot it happens, so you can
explain it if asked.

## Project structure

```
spring-learn/
├── pom.xml
├── src/main/java/com/cognizant/springlearn/
│   ├── SpringLearnApplication.java     # main() + displayDate/displayCountry/displayCountries (docs 1)
│   ├── GlobalExceptionHandler.java     # doc 4
│   ├── controller/
│   │   ├── HelloController.java        # doc 2 - GET /hello
│   │   ├── CountryController.java      # docs 2 & 4 - GET/POST /countries
│   │   ├── EmployeeController.java     # docs 3 & 4 - GET/PUT/DELETE /employees
│   │   ├── DepartmentController.java   # doc 3 - GET /departments
│   │   └── AuthenticationController.java # doc 5 - GET /authenticate
│   ├── service/
│   │   ├── CountryService.java
│   │   ├── EmployeeService.java
│   │   ├── DepartmentService.java
│   │   └── exception/CountryNotFoundException.java
│   ├── dao/
│   │   ├── EmployeeDao.java
│   │   └── DepartmentDao.java
│   ├── model/
│   │   ├── Country.java   Employee.java   Department.java   Skill.java
│   ├── exception/EmployeeNotFoundException.java
│   └── security/
│       ├── SecurityConfig.java
│       ├── JwtAuthorizationFilter.java
│       └── JwtUtil.java
├── src/main/resources/
│   ├── application.properties   # doc 1 hands-on 3 (logging config, server.port=8090)
│   ├── date-format.xml          # doc 1 hands-on 2
│   ├── country.xml              # doc 1 hands-on 4/5/6
│   └── employee.xml             # doc 3
└── src/test/java/.../SpringLearnApplicationTests.java   # doc 2 MockMvc tests
```

## How to run

```bash
cd spring-learn
mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 \
    -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050
mvn spring-boot:run
```
(Drop the `-Dhttp.proxy*` flags if you're not behind the Cognizant proxy.)

The app starts on **port 8090** (see `application.properties`).

## Try it out (matches the curl examples in the docs)

```bash
# Hello World (doc 2) - no auth required is NOT the case anymore once doc 5's
# security is added; every endpoint except /authenticate needs a token.

# 1. Get a JWT (doc 5)
curl -s -u user:pwd http://localhost:8090/authenticate
# => {"token":"eyJ..."}

# 2. Use the token to call a secured endpoint
TOKEN="paste token here"
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries
# => [{"code":"IN","name":"India"},{"code":"US","name":"United States"}, ...]

curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries/in
# => {"code":"IN","name":"India"}

curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries/zz
# => 404 {"timestamp":"...","status":404,"error":"Not Found","message":"Country not found",...}

# 3. POST with validation (doc 4)
curl -i -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' \
  -X POST -d '{"code":"I","name":"India"}' http://localhost:8090/countries
# => 400 Bad Request, "errors":["Country code should be 2 characters"]

curl -i -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' \
  -X POST -d '{"code":"IN","name":"India"}' http://localhost:8090/countries
# => 200 {"code":"IN","name":"India"}

# 4. Employees (doc 3 & 4)
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/employees
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/departments

curl -i -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' -X PUT \
  -d '{"id":1,"name":"John Smith","salary":60000,"permanent":true,"dateOfBirth":"14/05/1990"}' \
  http://localhost:8090/employees

curl -i -H "Authorization: Bearer $TOKEN" -X DELETE http://localhost:8090/employees/2
```

## Running tests

```bash
mvn clean test
```

Runs `SpringLearnApplicationTests` (doc 2's MockMvc scenarios), authenticated with the in-memory
`user`/`pwd` account since doc 5's security now covers every endpoint.

## Things worth knowing before you demo this

- **Singleton vs prototype (doc 1 hands-on 5):** `country.xml`'s `country` bean is singleton by
  default. Add `scope="prototype"` to that bean tag and re-run `displayCountry()` — the
  `Country()` constructor debug log will fire twice instead of once.
- **dateOfBirth is a String, not a Date:** documented with a code comment in `Employee.java` —
  Spring's XML bean wiring has no built-in String→Date converter without registering a
  `CustomEditorConfigurer`, so the field is a plain `dd/MM/yyyy` string to keep the XML-driven
  data setup simple, per doc 3/4's actual ask (no date-parsing hands-on was requested there).
- **Secret key for JWT is hardcoded** in `JwtUtil.java` for learning purposes only — comment
  in that file flags this explicitly as something to externalize in a real application.
