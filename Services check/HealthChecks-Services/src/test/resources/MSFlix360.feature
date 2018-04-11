#@All
Feature:MIcrosoft Flix360

IF I visit http://manage.flix360.com/microsoft
I should see the webpage

@MSF360status
Scenario:Http status

Given I Navigate to  "Microsoftflix360Portal"
Then I should be able to get the status of the "Microsoftflix360Portal"
