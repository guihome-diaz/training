// Ensure the Express library is present
const express = require('express');

// Initialise new Express application
const app = express();

// Simple web-service at the root
app.get('/', (req, res) => {
    res.send('Hi there, this is a simple application');
});

// Listen on port
app.listen(8080, () => {
    console.log('Listening on port 8080');
});