#Angular training

##Angular setup
Angular requires: 
* [Node JS LTS version](https://nodejs.org/en/) - version x64
* 

Optional: 
* [Visual Studio Code](https://code.visualstudio.com/)
  * Add extension "Prettier — Code Formatter"  
* [IntelliJ Ultimate](https://www.jetbrains.com/idea/download/#section=windows) 
  * Install Angular plugins
  * Then File | New | Module from existing sources

Official tutorials are available at: https://angular.io/guide/setup-local

### Google default application

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

## Exercices

* Create simple application (hello) and change the text - see dynamic loading
* Create simple application with routing
  * Create login page (new component 'login', with validation inside)
  * Adjust login form to send event to parent (login/password)
  * Adjust login form to: 
    * send event to parent ONLY if login == password
    * if login ok, display text + logout button
    * if login ko, display error

## Useful links

* [PrimeNG components](https://github.com/primefaces/primeng)
