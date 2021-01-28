import express from 'express';
import cors from 'cors';
import SessionServices from './SessionServices';
import ContactServices from './ContactServices';

class RestServer {
	constructor(config = null) {
		this._config = config;
		this._server = express();
		this._server.use(express.json());
		this._server.use(express.urlencoded({ extended: true }));
		this._server.use(cors());
		this._server.options('*', cors());
	}
	
	_getConfigOption(optionName, defaultValue) {
		let result = defaultValue;
		
		if (this._config && this._config[optionName]) {
			result = this._config[optionName];
		}
		
		return result;
	}
	
	_buildBaseUrl(urlFragment) {
		let result = this._getConfigOption('baseUrl', '/api');
		
		if (!result.endsWith('/')) {
			result += '/';
		}
		
		result += urlFragment;
		
		if (result.endsWith('/')) {
			result = result.substring(0, result.length - 1);
		}
		
		return result;
	}
	
	registerServices(urlFragment, serviceHandlerInstance) {
		const baseUrl = this._buildBaseUrl(urlFragment);
		
		for (let serviceDefinition of serviceHandlerInstance.getServiceDefinitions()) {
			const action = serviceDefinition.httpVerb.toLowerCase();
			const url = baseUrl + (serviceDefinition.urlSuffix ? '/' + serviceDefinition.urlSuffix : '');
			this._server[action](url, serviceDefinition.handler);
		}
	}
	
	start() {
		const port = this._getConfigOption('port', 5000);
		this._server.listen(port, () => {
			console.log(`REST Server started on port ${port}`);
		});
	}
}

const server = new RestServer({ port: 5000, baseUrl: '/api/', });
server.registerServices('session', new SessionServices());
server.registerServices('contact', new ContactServices());
server.start();
