# URL Shortener Specification

In this task, you'll design and implement a **URL shortener** while leading the solution, with the interviewer available to prompt, guide, and ask questions as needed.

To succeed, please familiarize yourself with the problem ahead of time, do some design thinking, and be prepared. The code will be made available **before the interview**, so take this opportunity to understand the expected functionality and system design considerations.

> **Before the interview, please:**
> - Choose the tech stack you'd like to use for the backend.
> - Set up your development environment so that it integrates with the provided frontend. You can use Docker Compose or run your backend locally, please just ensure the frontend can reach your service via the network.
> - Feel free to jot down notes or sketch ideas so we can hit the ground running when the session starts.

## 1. Setup

You will receive a repository containing the following:
- **React Frontend** - A pre-built UI for the URL shortener.
- **Python Backend Stub** - A minimal backend with hardcoded responses.
- **Docker Compose** - To run both services seamlessly.

**To run the application:**
```bash
git clone https://github.com/cyberark/hiring-exercise.git
cd hiring-exercise
docker compose up --build
```

## 2. Backend API Specification

### Shorten a URL
**Endpoint:** `POST /api/shorten`  

**Request:**
```json
{
    "url": "https://www.example.com/very/long/path"
}
```

**Response:**
```json
{
    "short_code": "abc123",
    "short_url": "http://localhost:8080/abc123",
    "original_url": "https://www.example.com/very/long/path"
}
```
**Behavior:**  
The backend should generate a unique short code, store the mapping, and return the original URL along with the short URL.

---

### Redirect to Original URL
**Endpoint:** `GET /<short_code>`  

**Behavior:**  
Redirects the user to the original URL. If the code doesn't exist, return a 404 error.

## 3. Task for the Candidate
- Implement URL shortening logic.
- Store shortened URLs efficiently.
- Ensure the backend serves redirection requests.
- Handle invalid inputs and non-existent short codes gracefully.
- Optimize for performance (if relevant).

## 4. Logistics
– Estimated time: **90 minutes** (you'll lead the coding, but the interviewer may prompt, unblock or ask questions as needed).
- Submission: A **GitHub URL**, a **Git bundle**, or another suitable format.

> **Note:**  
> You will be asked to explain your approach and thought process during the session.

*Good luck! 🚀*
