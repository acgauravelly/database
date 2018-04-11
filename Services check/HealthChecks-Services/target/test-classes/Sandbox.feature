@All
Feature:Sandbox

IF I visit http://sandbox.flixsyndication.net
I should see the webpage

@SBstatus
Scenario:Http status

Given I Navigate to  "SandboxUrl"
Then I should be able to get the status of the "SandboxUrl"
