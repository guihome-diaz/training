# Angular training

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

## Useful links

* [PrimeNG components](https://github.com/primefaces/primeng)
