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

## Exercices

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

* Create simple application with routing
  * Create login page (new component 'login', with validation inside)
    
```ng generate component login```
  * Adjust login form to send event to parent (login/password)
  * Adjust login form to: 
    * send event to parent ONLY if login == password
    * if login ok, display text + logout button
    * if login ko, display error
  * Add logout option to re-display the login form

## Useful links

* [PrimeNG components](https://github.com/primefaces/primeng)
