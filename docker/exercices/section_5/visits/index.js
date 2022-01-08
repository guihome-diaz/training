// Section 5: nodeJs application to count the number of visits
// @author Stephen Grider (trainer)
// @author Guillaume Diaz (trainee)
// @version 1.0, 2022/01

//*********************************
// Bootstrap
//*********************************
// Ensure the Express & Redis client libraries are present
const express = require('express');
const redis = require('redis');

// Initialise new Express application
const app = express();


//*********************************
// Configuration
//*********************************
var nodeJsAppLocalPort = 8081;
var redisServerHostName = 'redis-server';
var redisServerPorNumber = 6379;


//*********************************
// Establish connection(s)
//*********************************
// Create Redis connection
const redisClient = redis.createClient({
    // Name of the container who acts as data repository
    host: redisServerHostName,
    port: redisServerPorNumber
});


// ******************
// Business 
// ******************

// Initialise visit counter to 0 at startup
redisClient.set('visits', 0);

// *** Web-services ***
app.get('/', (req, res) => {
    // Retrieve number of visits
    redisClient.get('visits', (error, nbOfVisits) => {
        // Increment counter
        var totalVisits = parseInt(nbOfVisits) + 1;
        // display result
        res.send('<html><body><h1>Visits counter</h1><p>Number of visits: ' + totalVisits + '</p></body></html>');
        // save new value in server
        redisClient.set('visits', totalVisits);
    });
});


// Bind application to local port
app.listen(nodeJsAppLocalPort, () => {
    console.log('Listening on port ' + nodeJsAppLocalPort);
});