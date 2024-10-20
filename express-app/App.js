const express = require('express');
const path = require('path');

const app = express();
const PORT = 8001

// Middleware to serve static files
app.use(express.static('public'));

// Middleware to parse JSON bodies
app.use(express.json());

// Home route
app.get('/', (req, res) => {
    res.send('<h1>Welcome to the Express App!</h1>');
});

// About route
app.get('/about', (req, res) => {
    res.send('<h1>About Page</h1>');
});

// Sample POST route
app.post('/data', (req, res) => {
    const data = req.body;
    res.json({ message: 'Data received', data });
});

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);

});