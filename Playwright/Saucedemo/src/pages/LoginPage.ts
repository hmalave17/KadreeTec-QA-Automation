import { Page } from 'playwright';
import { ENV } from '../support/env';

export class LoginPage {
    constructor(private page: Page) { }

    private usernameInput = '#user-name';
    private passwordInput = '#password';
    private loginButton = '#login-button';
    private appLogo = '.app_logo';
    private errorMessage = '[data-test="error"]';

    async open() {
        await this.page.goto(ENV.BASE_URL);
    }

    async login(username: string, password: string) {
        await this.page.fill(this.usernameInput, username);
        await this.page.fill(this.passwordInput, password);
        await this.page.click(this.loginButton);
    }

    async isLoggedIn(): Promise<boolean> {
        const logo = this.page.locator(this.appLogo);
        await logo.waitFor({ state: 'visible', timeout: 5000 });
        return true;
    }

    async loginOnlyUsername(username: string) {
        await this.page.fill(this.usernameInput, username);
        await this.page.click(this.loginButton);
    }

    async loginOnlyPassword(password: string) {
        await this.page.fill(this.passwordInput, password);
        await this.page.click(this.loginButton);
    }

    async getError(): Promise<string> {
        const locator = this.page.locator(this.errorMessage);
        await locator.waitFor({ state: 'visible', timeout: 3000 });
        const text = await locator.textContent();
        return text!.trim();
    }
}
