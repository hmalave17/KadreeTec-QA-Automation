import { Given, When, Then } from '@cucumber/cucumber';
import { CustomWorld } from '../support/world';
import { LoginPage } from '../pages/LoginPage';
import { expect } from 'chai';
import loginData from '../data/loginData.json';

const { username, password } = loginData.validUser;

Given('user open webside', async function (this: CustomWorld) {
  const page = this.page!;
  this.loginPage = new LoginPage(page);
  await this.loginPage.open();
});

When('user into her data', async function (this: CustomWorld) {
  await this.loginPage.login(username, password);
});

When('user into her data {string}', async function (this: CustomWorld, username: string) {
    await this.loginPage.login(username, password);
  });

When('user doesnot send username', async function (this: CustomWorld) {
  await this.loginPage.loginOnlyPassword(password);
});

When('user doesnot send password', async function (this: CustomWorld) {
  await this.loginPage.loginOnlyUsername(username);
});

Then('system show webside', async function (this: CustomWorld) {
  const isLoggedIn = await this.loginPage.isLoggedIn();
  expect(isLoggedIn).to.equal(true);
});

Then('system show error {string}', async function (this: CustomWorld, expectedMessage: string) {
  const error = await this.loginPage.getError();
  expect(error).to.include(expectedMessage);
});

Then('system show error', async function (this: CustomWorld) {
  const error = await this.loginPage.getError();
  expect(error.toLowerCase()).to.include('required');
});

