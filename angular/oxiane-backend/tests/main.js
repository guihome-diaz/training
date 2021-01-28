const fetch = require('isomorphic-fetch');

const BASE_URL = 'http://localhost:5000/api/';

function JSONStringify(object) {
	var cache = []; 
	       
	var str = JSON.stringify(
		object,
		function(key, value) {
			if (typeof value === 'object' && value !== null) {
				if (cache.indexOf(value) !== -1) {
					// Circular reference found, discard key
					return;
				}
				
				// Store value in our collection
				cache.push(value);
			}
			
			return value;
		},
		4
	);
	
	cache = null;
	
	return str;
}

function processResponse(response) {
	if (("" + response.status).startsWith("2")) {
		const contentType = response.headers._headers['content-type'][0];
		
		if (contentType.startsWith('application/json')) {
			return response.json();
		} else {
			return response.text();
		}
	} else {
		return "" + response.status + " " + response.statusText;
	}
}

function login(userName, userPwd, handler) {
	return fetch(
		BASE_URL + 'session', {
		method: 'POST',
		mode: 'cors',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			'login': userName,
			'password': userPwd
		})
	}).then(response => {
		return processResponse(response);
	}).then(data => {
		handler(data);
	}).catch(error => {
		handler('ERROR: ' + error);
	});
}

function logout(sessionId, handler) {
	fetch(
		BASE_URL + 'session?id=' + sessionId, {
		method: 'DELETE',
		mode: 'cors',
	}).then(response => {
		return processResponse(response);
	}).then(data => {
		handler(data);
	}).catch(error => {
		handler('ERROR: ' + error);
	});
}

login('user', 'pwd', data => console.log("Bad login: " + JSONStringify(data)));
login('user', 'user', data => console.log("Good login: " + JSONStringify(data)));
logout('1', data => console.log("Logout: " + JSONStringify(data)));
