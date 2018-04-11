@All
Feature:Signup Portal

IF I visit http://signup.flixsyndication.net
I should see the webpage

@SUPstatus
Scenario:Http status

Given I Navigate to  "SignUpPortal"
  Then I should be able to see the "SignUpPortalUsernameField" and "SignUpPortalPasswordField"
