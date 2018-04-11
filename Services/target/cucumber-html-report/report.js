$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AdminFlix360.feature");
formatter.feature({
  "line": 2,
  "name": "As an admin flix360 user",
  "description": " I navigate to the url and check if service is available",
  "id": "as-an-admin-flix360-user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Admin flix360 interface is available",
  "description": "",
  "id": "as-an-admin-flix360-user;admin-flix360-interface-is-available",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@AF360"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I navigate to \"adminFlix360\" Url",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I should be able to check the \"LoginForm\"  is displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "adminFlix360",
      "offset": 15
    }
  ],
  "location": "AllServicesTests.iNavigateTo(String)"
});
formatter.result({
  "duration": 8784332649,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LoginForm",
      "offset": 31
    }
  ],
  "location": "AllServicesTests.iShouldBeAbleToCheckTheIsDisplayed(String)"
});
formatter.result({
  "duration": 70826,
  "status": "passed"
});
formatter.after({
  "duration": 142507,
  "status": "passed"
});
formatter.uri("AttachWidget.feature");
formatter.feature({
  "line": 2,
  "name": "As a  user",
  "description": "I navigate to the url and check if Attach widget service is available",
  "id": "as-a--user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Attach Widget interface is available",
  "description": "",
  "id": "as-a--user;attach-widget-interface-is-available",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@AW"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I navigate to \"aw\" Url",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I should be able to check the \"aw\"  is displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "aw",
      "offset": 15
    }
  ],
  "location": "AllServicesTests.iNavigateTo(String)"
});
formatter.result({
  "duration": 17882101911,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "aw",
      "offset": 31
    }
  ],
  "location": "AllServicesTests.iShouldBeAbleToCheckTheIsDisplayed(String)"
});
formatter.result({
  "duration": 13164703362,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"class name\",\"selector\":\"flix-mscomp-container\"}\nCommand duration or timeout: 5.08 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027FLIXPC010\u0027, ip: \u0027192.168.1.223\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d45.0.1, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 1c9f1987-ec07-4c8d-b979-c9a45a6cbad7\n*** Element info: {Using\u003dclass name, value\u003dflix-mscomp-container}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByClassName(RemoteWebDriver.java:477)\r\n\tat org.openqa.selenium.By$ByClassName.findElement(By.java:391)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat Pages.BasePage.findElement(BasePage.java:31)\r\n\tat Pages.BasePage.isElementDisplayed(BasePage.java:66)\r\n\tat Pages.AllServicesPage.isComparisionTableisDisplayed(AllServicesPage.java:86)\r\n\tat Tests.AllServicesTests.iShouldBeAbleToCheckTheIsDisplayed(AllServicesTests.java:38)\r\n\tat ✽.Then I should be able to check the \"aw\"  is displayed(AttachWidget.feature:10)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"class name\",\"selector\":\"flix-mscomp-container\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027FLIXPC010\u0027, ip: \u0027192.168.1.223\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/Ajay/AppData/Local/Temp/anonymous5453015069768017607webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.fxdriver.Timer.prototype.setTimeout/\u003c.notify(file:///C:/Users/Ajay/AppData/Local/Temp/anonymous5453015069768017607webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:625)\r\n",
  "status": "failed"
});
formatter.write("Failed Scenario: Attach Widget interface is available");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 745443739,
  "status": "passed"
});
formatter.uri("DartyServices.feature");
formatter.feature({
  "line": 2,
  "name": "As a  user",
  "description": "I navigate to the url and check if Comparision Table service is available",
  "id": "as-a--user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I navigate to \"darty\" Url",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "darty",
      "offset": 15
    }
  ],
  "location": "AllServicesTests.iNavigateTo(String)"
});
formatter.result({
  "duration": 94125403573,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Comparision  Table interface is available",
  "description": "",
  "id": "as-a--user;comparision--table-interface-is-available",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@AF360"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I should be able to check the \"comparision table\"  is displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "comparision table",
      "offset": 31
    }
  ],
  "location": "AllServicesTests.iShouldBeAbleToCheckTheIsDisplayed(String)"
});
formatter.result({
  "duration": 20541622347,
  "status": "passed"
});
formatter.after({
  "duration": 42667,
  "status": "passed"
});
});