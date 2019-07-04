
Feature: Register new user		    
		  Scenario: User enters an already registered mail
		  	 Given User goes to logged in to the PHPtravels portal
		    When user enter first name 
		    And enter last name
		    And enter mobile number
		    And enter an already registered mail mail
		    And enter valid password
		    And enter confirmation for password 
		    And clicks on sign up button
		    Then and error appears that the mail is already registered
		  
		  