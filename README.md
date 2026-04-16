# Application for Codeit Internship, made by Andrej Trajkovski

# Earthquake Management Application

A complete full-stack application for fetching, storing, and displaying earthquake data from the USGS GeoJSON feed.

## Tech Stack
- Backend: Spring Boot 4, Java 21, Spring Data JPA
- Frontend: React 19 + Vite 8 + Axios + Bootstrap 5
- Database: PostgreSQL 14
- API documentation: Swagger UI (`springdoc-openapi`)
- Testing (backend): JUnit + H2 (test profile)

## Module documentation
- Backend details: `backend/README.md`
- Frontend details: `frontend/README.md`

## Project setup instructions
1. Install:
   - JDK 21
   - Maven (or use the `./mvnw` wrapper)
   - Node.js 20+ and npm
   - PostgreSQL 14+
2. Clone the project and open the `backend` and `frontend` folders.
3. Configure PostgreSQL using the "Database configuration steps" section.
4. Install frontend dependencies.

## How to run backend and frontend
1. Start the backend (port `8080`):
   ```bash
   cd earthquake_management/backend
   ./mvnw spring-boot:run
   ```
2. Start the frontend (port `5173`):
   ```bash
   cd earthquake_management/frontend
   npm install
   npm run dev
   ```
3. Open:
   - Frontend: `http://localhost:5173`
   - Backend API: `http://localhost:8080/api/earthquakes`
   - Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## Database configuration steps
1. Create a PostgreSQL database:
   ```sql
   CREATE DATABASE "earthquakeDB";
   ```
2. Create/select a user that matches `backend/src/main/resources/application.properties`:
   - `spring.datasource.username=andrej`
   - `spring.datasource.password=` (empty in the current configuration)
3. If you want different credentials, change them in `backend/src/main/resources/application.properties`.
4. The application automatically manages tables with:
   - `spring.jpa.hibernate.ddl-auto=update`

## Any assumptions made
- PostgreSQL is available locally on `localhost:5432`.
- Backend and frontend run locally on the default ports `8080` and `5173`.
- Frontend communicates with backend via `http://localhost:8080/api/earthquakes`.
- Internet connectivity is available for the USGS feed (`all_hour.geojson`).

## Any optional improvements implemented
- Swagger/OpenAPI documentation is included (`springdoc-openapi-starter-webmvc-ui`).
- Custom exceptions are implemented with corresponding HTTP status codes.
- Integration tests are added with the `test` profile and an H2 in-memory database.
- Records with magnitude `> 2.0` are filtered before saving.