# URL Shortener - Software Engineering Exercise

This repository contains a stub implementation of a simple URL shortener application, used as part of our software engineering interview exercise.

The exercise is designed to last approximately 90 minutes and is not a strict pair programming session. The candidate is expected to lead the implementation, while the interviewer may prompt, guide, and ask questions as needed. The focus is on assessing problem-solving ability, system design thinking, implementation skills, and communication.

During the session, the candidate is expected to:
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

