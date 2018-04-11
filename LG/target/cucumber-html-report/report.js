$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Scraping.feature");
formatter.feature({
  "line": 2,
  "name": "Scrape LG website for urls",
  "description": "",
  "id": "scrape-lg-website-for-urls",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "LG Scraping",
  "description": "",
  "id": "scrape-lg-website-for-urls;lg-scraping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@commercial"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I visit the \"commercial\" url",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I get the product details",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I should be able to write to a csv",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "commercial",
      "offset": 13
    }
  ],
  "location": "LGTests.iVisitThe(String)"
});
formatter.result({
  "duration": 220529443,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iGetTheProductDetails()"
});
formatteformatter.result({
  "duration": 5342015107866,
  "error_message": "org.openqa.selenium.ElementNotVisibleException: element not visible\n  (Session info: chrome\u003d58.0.3029.110)\n  (Driver info: chromedriver\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 34 milliseconds\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027FLIXPC010\u0027, ip: \u0027192.168.1.96\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233), userDataDir\u003dC:\\Users\\Ajay\\AppData\\Local\\Temp\\scoped_dir7772_14795}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d58.0.3029.110, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 5fc50c2a2ac184adf4c8f68edbae4543\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:85)\r\n\tat Pages.LG.getInfo(LG.java:67)\r\n\tat Tests.LGTests.iGetTheProductDetails(LGTests.java:24)\r\n\tat ✽.And I get the product details(Scraping.feature:22)\r\n",
  "status": "failed"
})formatter.match({
  "location": "LGTests.iShouldBeAbleToWriteToACsv()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("Failed Scenario: LG Scraping");
;
f [[ChromeDriver: chrome on XP (6c3fd2f14e7dcb61791759ee89cc1d51)] -\u003e class name: btn]\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027FLIXPC010\u0027, ip: \u0027192.168.1.96\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233), userDataDir\u003dC:\\Users\\Ajay\\AppData\\Local\\Temp\\scoped_dir10464_15308}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d58.0.3029.110, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 6c3fd2f14e7dcb61791759ee89cc1d51\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:261)\r\n\tat Pages.BasePage.waitForElement(BasePage.java:237)\r\n\tat Pages.LG.getInfo(LG.java:68)\r\n\tat Tests.LGTests.iGetTheProductDetails(LGTests.java:24)\r\n\tat ✽.And I get the product details(Scraping.feature:22)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LGTests.iShouldBeAbleToWriteToACsv()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("Failed Scenario: LG Scraping");
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 360285201,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "LG Scraping",
  "description": "",
  "id": "scrape-lg-website-for-urls;lg-scraping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 25,
      "name": "@outdoor"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "I visit the \"outdoor\" url",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "I get the product details",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I should be able to write to a csv",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "outdoor",
      "offset": 13
    }
  ],
  "location": "LGTests.iVisitThe(String)"
});
formatter.result({
  "duration": 3055890869,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iGetTheProductDetails()"
});
formatter.result({
  "duration": 124558658234,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iShouldBeAbleToWriteToACsv()"
});
formatter.result({
  "duration": 835102438,
  "status": "passed"
});
formatter.after({
  "duration": 26026,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "LG Scraping",
  "description": "",
  "id": "scrape-lg-website-for-urls;lg-scraping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 32,
      "name": "@accessories"
    }
  ]
});
formatter.step({
  "line": 35,
  "name": "I visit the \"accessories\" url",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "I get the product details",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I should be able to write to a csv",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "accessories",
      "offset": 13
    }
  ],
  "location": "LGTests.iVisitThe(String)"
});
formatter.result({
  "duration": 7802196143,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iGetTheProductDetails()"
});
formatter.result({
  "duration": 93454219869,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iShouldBeAbleToWriteToACsv()"
});
formatter.result({
  "duration": 717649865,
  "status": "passed"
});
formatter.after({
  "duration": 45227,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "LG Scraping",
  "description": "",
  "id": "scrape-lg-website-for-urls;lg-scraping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 39,
      "name": "@desktop"
    }
  ]
});
formatter.step({
  "line": 42,
  "name": "I visit the \"desktop-monitors\" url",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "I get the product details",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "I should be able to write to a csv",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "desktop-monitors",
      "offset": 13
    }
  ],
  "location": "LGTests.iVisitThe(String)"
});
formatter.result({
  "duration": 7033190456,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iGetTheProductDetails()"
});
formatter.result({
  "duration": 147846867366,
  "error_message": "java.lang.IndexOutOfBoundsException: Index: 3, Size: 0\r\n\tat java.util.ArrayList.rangeCheck(ArrayList.java:653)\r\n\tat java.util.ArrayList.get(ArrayList.java:429)\r\n\tat Pages.LG.getInfo(LG.java:67)\r\n\tat Tests.LGTests.iGetTheProductDetails(LGTests.java:24)\r\n\tat ✽.And I get the product details(Scraping.feature:43)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LGTests.iShouldBeAbleToWriteToACsv()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("Failed Scenario: LG Scraping");
formatter.embedding("image/png", "embedded2.png");
formatter.after({
  "duration": 215288261,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "LG Scraping",
  "description": "",
  "id": "scrape-lg-website-for-urls;lg-scraping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 46,
      "name": "@digitalStorage"
    }
  ]
});
formatter.step({
  "line": 49,
  "name": "I visit the \"digital-storage\" url",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "I get the product details",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "I should be able to write to a csv",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "digital-storage",
      "offset": 13
    }
  ],
  "location": "LGTests.iVisitThe(String)"
});
formatter.result({
  "duration": 5088874818,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iGetTheProductDetails()"
});
formatter.result({
  "duration": 15014427332,
  "status": "passed"
});
formatter.match({
  "location": "LGTests.iShouldBeAbleToWriteToACsv()"
});
formatter.result({
  "duration": 716494450,
  "status": "passed"
});
formatter.after({
  "duration": 25173,
  "status": "passed"
});
});