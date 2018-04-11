#@All
Feature:Inline SIS
If I visit http://www.ebuyer.com/seagate-product-selector/
I should be able to see the inline SIS page

@INlineSIS
Scenario:
Given Iam on InlineSis page
Then I should be able to see our InlineSIS content
