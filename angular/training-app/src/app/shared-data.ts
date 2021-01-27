export class SharedData {

  sessionId: string;
  errorMessage: string;

  isLoggedIn() {
    return (this.sessionId !== undefined);
  }
  
}
