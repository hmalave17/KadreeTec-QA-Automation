class LoginPage {
  elements = {
    usernameInput: () => cy.get('#user-name'),
    passwordInput: () => cy.get('#password'),
    loginButton: () => cy.get('#login-button'),
    errorMessage: () => cy.get('[data-test="error"]')
  };

  navigate() {
    cy.visit('/');
  }

  login(username, password) {
    if (username) this.elements.usernameInput().type(username);
    if (password) this.elements.passwordInput().type(password);
    this.elements.loginButton().click();
  }

  loginWithoutUsername(password) {
    if (password) this.elements.passwordInput().type(password);
    this.elements.loginButton().click();
  }

  loginWithoutPassword(username) {
    if (username) this.elements.usernameInput().type(username);
    this.elements.loginButton().click();
  }

  getError() {
    return this.elements.errorMessage().invoke('text');
  }
}

module.exports = new LoginPage();
