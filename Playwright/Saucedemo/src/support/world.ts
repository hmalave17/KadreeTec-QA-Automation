import { IWorldOptions, setWorldConstructor } from '@cucumber/cucumber';
import { Page, Browser, BrowserContext } from 'playwright';

export class CustomWorld {
  browser!: Browser;
  context!: BrowserContext;
  page!: Page;

  loginPage: any;

  constructor(options: IWorldOptions) {
    Object.assign(this, options);
  }
}

setWorldConstructor(CustomWorld);