Feature: Logging into account

  Scenario Outline: Logging into account
    Given User is on login page
    When User enters username <usernames>
    And User enters password <passwords>
    Then User is succesfully logged in

    Examples: 
      | usernames        | passwords                |
      | symbol@stage.com | dSQCstFb2Gy9O7LWsj9xBw== |
