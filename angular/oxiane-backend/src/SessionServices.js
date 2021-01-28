import BaseServiceHandler from './BaseServiceHandler';

export default class SessionServices extends BaseServiceHandler {
	constructor() {
		super();
	}
	
	create(request, response) {
		// Simulate authentication service
		let status = request.body.login && request.body.login === request.body.password ? 200 : 403;
		
		// Create a session object for the user
		let clientIP = (request.headers['x-forwarded-for'] || request.connection.remoteAddress || '').split(',')[0].trim();
		let sessionId = status === 200 ? this.createSession(request.body.login, clientIP) : null;

		let body = status === 200 ? { "sessionId": sessionId, } : {};
		response.status(status).send(body);
	}
	
	// Logout URL: /api/session?id=23fe7b-1421-9212-12acf12
	delete(request, response) {
		if (this.deleteSession(request.query.id)) {
			response.status(200).send({ "sessionId": null, });
		} else {
			response.status(404).send({});
		}
	}
}
