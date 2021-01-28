This is a mock REST API server written in JavaScript.
------------------------------------------------------------------------

To build it, type:

```
npm install
npm run build
```

To start the server, type:
```
npm run start
```

The following services are implemented:

|URL                                      | Method | Service|
|-----------------------------------------|--------|---------------------|
|http://localhost:5000/api/session        | POST   | login
|http://localhost:5000/api/session?id=<n> | DELETE | logout
|http://localhost:5000/api/contact        | GET    | list contacts
|http://localhost:5000/api/contact?id=<n> | GET    | get contact by id
|http://localhost:5000/api/contact        | POST   | create contact
|http://localhost:5000/api/contact        | PUT    | update contact
|http://localhost:5000/api/contact?id=<n> | DELETE | delete contact by id

The login service expects the `login` and `password` fields in 
the request body. Login will be accepted if both fields contain
the same value.

Open http://localhost:5000/api/contact in your browser to see how
contact objects look like.

Latest version is available at https://gitlab.com/20-100-2fe/rest-mock
