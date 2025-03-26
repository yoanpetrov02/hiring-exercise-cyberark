# URL Shortener - Software Engineering Exercise

This repository contains a stub implementation of a simple URL shortener application, used as part of our software engineering interview exercise.

The exercise is conducted as a pair programming session (approximately 2 hours), where the candidate is expected to:
- Implement a backend service that accepts long URLs and generates short codes.
- Handle redirects for short codes.
- Discuss design decisions, edge cases, and scaling considerations.

This repository includes:
- A React frontend for user interaction.
- A FastAPI backend to handle URL shortening and redirection.
- A Docker setup to easily run both services.
- [The specification](./SPEC.md), please consult this for detailed exercise instructions.

## Getting Started

### Prerequisites
- Install Docker and Docker Compose (the only required dependency).

### Setup & Run
Clone the repository and start the services:
```sh
git clone https://github.com/cyberark/hiring-exercise.git
cd hiring-exercise
docker compose up --build
```
Once running:
- Frontend → [`http://localhost:3000`](http://localhost:3000)
- Backend API → [`http://localhost:5000`](http://localhost:5000)

To stop the services:
```sh
docker compose down
```

