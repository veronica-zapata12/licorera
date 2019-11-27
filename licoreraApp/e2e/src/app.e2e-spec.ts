import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {

  it('should display welcome message', () => {
    browser.get("http://localhost:4200/");

    expect(browser.getLocationAbsUrl()).toMatch("listarproductos");
  });

 
});
