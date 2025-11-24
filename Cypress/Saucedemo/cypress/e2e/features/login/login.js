import { Given, When, Then } from "@badeball/cypress-cucumber-preprocessor";
const LoginPage = require("../../../pages/LoginPage");; 
import loginData from "../../../fixtures/loginData.json";

const { username, password } = loginData.validUser;

Given("user opens the website", () => {
  cy.visit("/");
});

When("user enters valid credentials", () => {
  LoginPage.navigate();
  LoginPage.login(username, password);
});

When("user enters username {string}", (usr) => {
  LoginPage.navigate();
  LoginPage.login(usr, password);
});

When("user does not enter username", () => {
  LoginPage.navigate();
  LoginPage.loginWithoutUsername(password);
});

When("user does not enter password", () => {
  LoginPage.navigate();
  LoginPage.loginWithoutPassword(username);
});

Then("system should display products page", () => {
  cy.url().should("include", "inventory.html");
});

Then("system shows error {string}", (message) => {
  LoginPage.getError().should("contain", message);
});

Then("system shows required error", () => {
  LoginPage.getError().should("contain", "required");
});
