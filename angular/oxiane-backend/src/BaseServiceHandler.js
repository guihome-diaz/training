
export default class BaseServiceHandler {
	constructor() {
		this.servicesConfig = {};
		this._sessionCache = [];
		// Session Time To Live in milliseconds
		this.sessionTTL = 1800000;
	}

	setObjectProperty(targetObject, propertyName, sourceObject) {
		let propertyValue = sourceObject ? sourceObject[propertyName] : undefined;
		
		if (propertyValue === undefined) {
			propertyValue = null;
		}
		
		targetObject[propertyName] = propertyValue;
	}
	
	createSession(userId, ipAddress) {
		// Ensure session unicity
		for (let session of this._sessionCache) {
			if (session.userId === userId && session.ipAddress === ipAddress) {
				this.deleteSession(session.sessionid);
				break;
			}
		}
		
		// Create the session object
		let maxid = this._sessionCache.reduce(
			(maxId, session) => {
				let id = parseInt(session.sessionId, 10);
				
				return id > maxId ? id : maxId;
			},
			0
		);
		let sessionId = "" + (maxid + 1);
		let now = Date.now();
		
		this._sessionCache.push(
			{
				"sessionId": sessionId,
				"userId": userId,
				"ipAddress": ipAddress,
				"lastAccess": Date.now(),
			}
		);
		
		return sessionId;
	}
	
	_getSessionById(sessionId) {
		for (let session of this._sessionCache) {
			if (session.sessionId === sessionId) {
				return session;
			}
		}
		
		return null;
	}
	
	getUserId(sessionId) {
		let session = this._getSessionById(sessionId);
		
		return session ? session.userId : null;
	}
	
	deleteSession(sessionId) {
		let size = this._sessionCache.length;
		this._sessionCache = this._sessionCache.filter(s => s.sessionId != sessionId);
		
		return size != this._sessionCache.length;
	}
	
	isSessionValid(request) {
		let sessionId = request.body.sessionId || request.query.sessionId;
		let session = this._getSessionById(sessionId);
		let result = false;
		
		if (session) {
			let now = Date.now();
			result = (now - session.lastAccess) < this.sessionTTL;
			
			if (result) {
				session.lastAccess = now;
			} else {
				this.deleteSession(sessionId);
			}
		}
		
		return result;
	}
		
	_getServiceConfig(methodName) {
		let config = {
			httpVerb: null,
			urlSuffix: null,
		};
		
		if (methodName.startsWith('create')) {
			config.httpVerb = 'POST';
		} else if (methodName.startsWith('update')) {
			config.httpVerb = 'PUT';
		} else if (methodName.startsWith('read')) {
			config.httpVerb = 'GET';
		} else if (methodName.startsWith('delete')) {
			config.httpVerb = 'DELETE';
		}
		
		if (this.servicesConfig && this.servicesConfig[methodName]) {
			for (let propName in config) {
				if (this.servicesConfig[methodName][propName]) {
					config[propName] = this.servicesConfig[methodName][propName];
				}
			}
		}
		
		return config.httpVerb ? config : null;
	}
	
	getServiceDefinitions() {
		let result = [];
		
		for (let methodName of Object.getOwnPropertyNames(Object.getPrototypeOf(this))) {
			let method = this[methodName];
			
			if (method instanceof Function) {
				let serviceConfig = this._getServiceConfig(methodName);
				
				if (serviceConfig) {
					result.push({ ...serviceConfig, handler: method.bind(this) });
				}
			}
		}
		
		return result;
	}
}
