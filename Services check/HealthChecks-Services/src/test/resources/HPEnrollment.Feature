@All
Feature:HP Enrollment

IF I visit http://hpsis.flixsyndication.net
I should see the webpage

@HPEstatus
Scenario:Http status

Given I Navigate to  "HPEnrolmentPortal"
Then I should be able to get the status of the "HPEnrolmentPortal"
