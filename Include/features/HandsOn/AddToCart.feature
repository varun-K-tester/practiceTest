Feature: Adding product to cart

  Scenario Outline: Adding product to cart
    Given User is on PDP
    When User selects <location> <date>
    And Add to cart button is enabled <quantity>
    Then User clicks on add to cart button

    Examples: 
      | location | date        | quantity |
      | linton   | later_today |        1 |
