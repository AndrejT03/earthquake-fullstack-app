# Frontend - Earthquake Management

React + Vite frontend for displaying and deleting earthquakes, and triggering backend fetch.

## Project setup instructions
1. Requirements:
   - Node.js 20+
   - npm
2. Open a terminal in `frontend`.
3. Install dependencies.

## How to run frontend
```bash
cd earthquake_management/frontend
npm install
npm run dev
```

Frontend runs by default on `http://localhost:5173`.

## Backend integration
- Frontend service uses: `http://localhost:8080/api/earthquakes`
- UI actions:
  - `Fetch Latest Earthquakes` -> `GET /api/earthquakes/fetch`
  - Table load -> `GET /api/earthquakes`
  - Delete button -> `DELETE /api/earthquakes/{id}`

## Database configuration steps
- Frontend has no direct database configuration.
- Backend must be configured and running with PostgreSQL (see `backend/README.md`).

## Any assumptions made
- Backend is available at `http://localhost:8080`.
- CORS is allowed for origin `http://localhost:5173`.
- Returned data contains fields: `id`, `magnitude`, `place`, `title`, `time`.

## Any optional improvements implemented
- `axios` service layer (`src/services/earthquakeService.js`) is used instead of inline API calls.
- Bootstrap styling is used for the table and action buttons.
- The list refreshes automatically after fetch and delete actions.