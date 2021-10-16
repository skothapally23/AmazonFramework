Feature: Feature to test login functionality

Background: Login in to amazon application successfully 

	Given user launch "chrome" browser and enter url
	When i will enter valid Email or mobile phone number
	And click on continue
	Then it will redirected to another page to enter password
	And click on signin
 	Then It will navigate to home page.
 	
#Scenario: Search for the product
#	Given User is in Amazon application
#	When user will search for product <product> and click on enter.
#	Then user will add filter of Low to High
#	And user will select the laptop and click on the product
#	When Product is displayed, user will add the product to cart
#	Then verify the product added in the cart 
#	
#Examples:
#	|product|
#	|Dell laptop|
#	
Scenario: Click on multipule tabs

Given User will click on any of the following tabs given below <tabs>
Examples:
|tabs|
|All|
|Fresh|

 	