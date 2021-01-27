export class SharedData {

  sessionId: string;
  errorMessage: string;

  isLoggedIn() {
    return (this.sessionId !== undefined);
  }

  setError(err: any) {
    if (err["status"] === 403) {
      this.errorMessage = 'Access denied'
    } else if (err["message"]) {
      this.errorMessage = err["message"];
    }
    this.errorMessage = err['message'];
  }

  clearError() {
    this.errorMessage = undefined;
  }

}
