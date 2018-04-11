@All
Feature:Shop in Shop
IF I Visit http://alliancetechpartners.com/hp-new-products/workstation-family/
I should be able to see the SIS content loaded with in 60 secs

@sis
Scenario:SIS Content
Given I am on SIS page
Then I should be able to see our SIS content appeared
