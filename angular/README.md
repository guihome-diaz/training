# Angular training

## Requirements

This code uses:
* Angular CLI: 11.1.1
* Node: 14.15.4 (LTS)
* typescript: 4.1.3

Requirements based on `ng --version` at training time.


## How to run ?

* Checkout the project
* Build it: 
  * `npm install`
  * `ng build`


## Angular setup
Angular requires: 
* [Node JS LTS version](https://nodejs.org/en/) - version x64


Optional: 
* [Visual Studio Code](https://code.visualstudio.com/)
  * Add extension "Prettier — Code Formatter"  
* [IntelliJ Ultimate](https://www.jetbrains.com/idea/download/#section=windows) 
  * Install Angular plugins
  * Then File | New | Module from existing sources

Official tutorials are available at: https://angular.io/guide/setup-local

## Exercises

### Exercise 1: discover Angular
* Create simple application (hello) and change the text - see dynamic loading

```bash
# Install the Angular CLI
npm install -g @angular/cli
# Create a workspace and initial application (accept defaults)
ng new my-app
# Run the application
cd my-app
ng serve --open
# Navigate to http://localhost:4200/.
```

(i) Windows users: __don't forget to update the PATH variable__
* NODEJS = G:\Dev\Tools\nodejs\
* PATH
  * %NODEJS%
  * C:\Users\guill\AppData\Roaming\npm
  * C:\Users\guill\AppData\Roaming\npm\node_modules\@angular\cli

### Exercise 2: simple login form
* Create simple application with routing
  * Create login page (new component 'login', with validation inside)
    
```ng generate component login```


### Exercise 3: login / logout form
* Adjust login form to send event to parent (login/password)
* Adjust to: 
  * send event to parent ONLY if login == password
  * if login ok, display text + logout button
  * if login ko, display error
* Add logout option to re-display the login form

### Exercise 4: Create module 

* Create new module session

```ng generate module session```

* move "login" _component_ to session _module_ (edit `app.module.ts` and `session.module.ts`, see "descriptions" and "imports/exports")
* create new _component_ "logout" in session module
  
  ```ng generate component session/logout```

### Exercise 5: create new class to handle session ID and error

* Create new class, __at the root of the project__

```ng generate class shared-data```

* Add 2 attributes (sessionId, errorMessage)
* Configure injection
* Create components StatusBar (display user info) + Footer
* Let user logout from banner

### Exercise 6: use OXIANE backend (http calls)

* Fork [Backend mocks](https://gitlab.com/20-100-2fe/rest-mock)
* Build and run the backend

```
# Build
npm install
npm run build
# Start 
npm run start
```

You can access the mock at [http://localhost:5000/api/contact](http://localhost:5000/api/contact)

* Adjust the application 
  * Create new service to use HTTP calls with 2 methods: login(..) + logout()
    
    ```ng generate service session/session```
    
  * Adjust module configuration (session.module.ts)
  * Use this for login / logout


### Exercise 7: create contact manager

* Create new module contact
* create new CRUD service to manage contacts + classes to host corresponding values (contact, address)
* Use OXIANE mocks, see `ContactServices.js`
* Create components to manage, list and view contacts

```
ng generate module contact
ng generate service contact/contact
ng generate class contact/contact
ng generate class contact/address
# root component for contact management
ng generate component contact/contact-mgr
# display 1 contact summary, within a list
ng generate component contact/contact-item
# view 1 contact in particular
ng generate component contact/contact-details
```

* Part 1: list the contacts. >> Use CALLBACK function
* Part 2: handle contact selection >> use event handling + display details


### Exercise 8: route management

PART 1: no security

* Create 2 new components: dashboard (to be displayed after login), about (application details)
* Add routing
  * try: http://localhost:4200/login
  * try: http://localhost:4200/about
  * try: http://localhost:4200/contact
  * try: http://localhost:4200/dashboard
  

PART 2: add security guard

* Create class
```ng generate class activable-when-logged-in```
* Add @Injectable + implements CanActivate



## Useful links

* [PrimeNG components](https://github.com/primefaces/primeng)
