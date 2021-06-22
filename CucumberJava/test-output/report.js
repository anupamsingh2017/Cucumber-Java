$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/CreateAccount.feature");
formatter.feature({
  "name": "As a new user I should be able to create a new account and carry out shopping activity",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a new user I should be able to create a new account, logout from app then login again",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I go to Sign In page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateAccountSteps.i_go_to_sign_in_page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign In button and wait for Authentication page to load",
  "keyword": "When "
});
formatter.match({
  "location": "CreateAccountSteps.i_click_on_sign_in_button_and_wait_for_authentication_page_to_load()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see Authentication Page",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_authentication_page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see Create an Account segment",
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_create_an_account_segment()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I enter my email address",
  "keyword": "When "
});
formatter.match({
  "location": "CreateAccountSteps.i_enter_my_email_address()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I click on Create an Account button",
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.i_click_on_create_an_account_button()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see Create an Account form page",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_create_an_account_form_page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I fill all the required details and submit it",
  "rows": [
    {
      "cells": [
        "title",
        "fname",
        "lname",
        "password",
        "dob",
        "address",
        "mobile"
      ]
    },
    {
      "cells": [
        "Mr.",
        "Anupam",
        "Singh",
        "a12345",
        "23-1-1993",
        "Gaur Galaxy,Noida,Connecticut,20101",
        "9876543213"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "CreateAccountSteps.i_fill_all_the_required_details_and_submit_it(DataTable)"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of [[ChromeDriver: chrome on WINDOWS (c0932b4933c063b166754056c647f707)] -\u003e id: days] (tried for 10 second(s) with 500 milliseconds interval)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027BMT-LAP-71\u0027, ip: \u0027192.168.29.142\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002715.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 91.0.4472.77, chrome: {chromedriverVersion: 91.0.4472.101 (af52a90bf870..., userDataDir: C:\\Users\\ANUPAM~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:57360}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: c0932b4933c063b166754056c647f707\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:95)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\r\n\tat core.DriverHelper.waitForElementToBePresent(DriverHelper.java:76)\r\n\tat core.DriverHelper.selectFromDropdownList(DriverHelper.java:86)\r\n\tat pageObjects.CreateAccountPage.fillPersonalInformation(CreateAccountPage.java:96)\r\n\tat stepDefinitions.CreateAccountSteps.i_fill_all_the_required_details_and_submit_it(CreateAccountSteps.java:67)\r\n\tat ✽.I fill all the required details and submit it(file:src/test/resources/features/CreateAccount.feature:12)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "As a new user I should be able to create a new account, logout from app then login again_2021-06-21_23:06:29");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see My Account page",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_my_account_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I should see that my correct name is displayed as \"Anupam Singh\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_that_my_correct_name_is_displayed(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I click on Sign out button",
  "keyword": "When "
});
formatter.match({
  "location": "CreateAccountSteps.i_click_on_sign_out_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I should see Authentication Page",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_authentication_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I should see Already Registered segment",
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_already_registered_segment()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I enter my registered email address and password",
  "keyword": "When "
});
formatter.match({
  "location": "CreateAccountSteps.i_enter_my_registered_email_address_and_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I click on Sign In button",
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.i_click_on_sign_in_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I should see My Account page",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_my_account_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "I should see that my correct name is displayed as \"Anupam Singh\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.i_should_see_that_my_correct_name_is_displayed(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});