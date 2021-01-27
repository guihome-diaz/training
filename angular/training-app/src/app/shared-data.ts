export class SharedData {

  sessionId: string;
  errorMessage: string;

  isLoggedIn() {
    return (this.sessionId !== undefined);
  }

  setHttpError(err: Error) {
    this.errorMessage = err.message;
  }

  clearError() {
    this.errorMessage = undefined;
  }

}
