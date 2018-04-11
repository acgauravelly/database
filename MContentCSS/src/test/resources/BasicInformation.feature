@All
Feature:BasicInformation
As a MC user
I should be able to ammend Basic Information


@BasicInformation
Scenario:Ability to add edit and delete basic information

Given I am logged in 
Given I am on the product page
And  edit the Basic Information
Then I should see the updated Basic Information





