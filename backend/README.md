# Backend - Earthquake Management

Spring Boot backend service for fetching data from USGS, storing it in PostgreSQL, and performing CRUD operations on earthquakes.

## Project setup instructions
1. Requirements:
   - JDK 21
   - Maven (or `./mvnw`)
   - PostgreSQL 14+
2. Open a terminal in the `backend` directory.
3. Check/update DB configuration in `src/main/resources/application.properties`.

## How to run backend
```bash
cd earthquake_management/backend
./mvnw spring-boot:run
```

Backend runs by default on `http://localhost:8080`.

## Database configuration steps
1. Create a database in PostgreSQL:
   ```sql
   CREATE DATABASE "earthquakeDB";
   ```
2. Make sure the `andrej` user exists (or change it in `application.properties`):
   - `spring.datasource.url=jdbc:postgresql://localhost:5432/earthquakeDB`
   - `spring.datasource.username=andrej`
   - `spring.datasource.password=`
3. Hibernate schema strategy is `update`, so tables are created/updated automatically.

## API endpoints
- `GET /api/earthquakes/fetch` - fetches from USGS and saves to DB
- `GET /api/earthquakes` - lists all saved earthquakes
- `DELETE /api/earthquakes/{id}` - deletes a record by ID

Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## Testing
```bash
cd earthquake_management/backend
./mvnw test
```

Tests use `application-test.properties` with an H2 in-memory database.

## Any assumptions made
- PostgreSQL is available locally on `localhost:5432`.
- Internet connectivity is available for USGS API calls.
- The frontend client accesses from `http://localhost:5173` (CORS is configured for this origin).

## Any optional improvements implemented
- `springdoc-openapi` integration for quick API testing.
- Custom exception classes for API unavailable, DB operation, and not-found cases.
- Integration tests for the service layer with an H2 test profile.
- A filter for earthquakes with magnitude above `2.0` before persistence.