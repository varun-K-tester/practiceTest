Feature: Logging into account

  Scenario Outline: Logging into account
    Given User is on login page
    When User enters username <username>
    And User enters password <password>
    Then User is succesfully logged in

    Examples: 
      | username | password |
      |        1 |        1 |
