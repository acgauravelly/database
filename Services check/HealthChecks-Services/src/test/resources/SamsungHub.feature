@All
Feature:Samsung Hub

IF I visit http://manage.flix360.com/samsung
I should see the webpage

@SHstatus
Scenario:Http status

Given I Navigate to the "SamsungHub"
Then I should be able to get the status of "SamsungHub"
