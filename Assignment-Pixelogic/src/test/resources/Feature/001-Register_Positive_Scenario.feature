
Feature: Register new user
		Scenario: User registers his mail successfully
		    Given User goes to logged in to the PHPtravels portal
		    When user enter first name 
		    And enter last name
		    And enter mobile number
		    And enter valid mail
		    And enter valid password
		    And enter confirmation for password 
		    And clicks on sign up button
		    Then user is navigated to another page
