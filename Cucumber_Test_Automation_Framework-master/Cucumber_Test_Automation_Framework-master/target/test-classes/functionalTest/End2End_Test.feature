Feature: End to End Functional Test 
         Ryanair Website Automation

Scenario: Automating booking of a flight in Ryanair Website
		Given user is on Home Page
		When user login the ryan air application with username and password
		And user selecting one way trip
		And user entering destination as " Berlin Brandenburg "
		And user entering departure date as "2020-12-04"
		And user entering adult count as "2" ,child count as "1" and infant count as "0"
		And user clicks search button
		And selecting a ticket and selecting fare
		And entering Adult1 details as "Mr Mathew Jose"
		And entering Adult2 details as "Mr Jose Mathew"
		And entering Child1 details as "Mr Mathew Sebastian"
		And clicking on Continue button
		And selecting seats
		And selecting baggage type
		And selecting shopping cart and checkout
		And entering contact details
		Then User should be asked to login before checkout
	
   