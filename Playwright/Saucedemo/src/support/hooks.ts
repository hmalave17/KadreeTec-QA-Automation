import { Before, After, setDefaultTimeout } from '@cucumber/cucumber';
import { chromium, Browser, BrowserContext, Page } from 'playwright';
import { CustomWorld } from './world';

setDefaultTimeout(60 * 1000); 

let browser: Browser;

Before(async function (this: CustomWorld) {
  browser = await chromium.launch({ headless: false });
  this.context = await browser.newContext();
  this.page = await this.context.newPage();
});

After(async function (this: CustomWorld) {
  await this.page?.close();
  await this.context?.close();
  await browser?.close();
});
