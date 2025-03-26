# URL Shortener Frontend

This is the pre-built React frontend for the URL shortener exercise, this project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

> Happy building! 🚀

## Getting Started

### Run the app:
```bash
npm install
npm start
```
The app will be available at [http://localhost:3000](http://localhost:3000).

## Features
- Input a long URL to shorten it.
- See a **list of recently shortened URLs** (stored in LocalStorage).
- **Click or copy** shortened URLs.
- **Validate a shortened URL** (see status code, headers, and response data).

## Development Notes
- The frontend expects a backend service running on `http://localhost:5000`.
- Update `proxy` in `package.json` if needed.
