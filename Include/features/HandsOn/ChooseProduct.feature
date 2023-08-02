Feature: Choosing product to order

  Scenario Outline: Navigating till PDP and choosing product
    Given User is on homepage
    When User navigate to menupage
    And User chooses <category L1> category L1
    And User chooses <category L2> category L2
    Then User chooses <product> product

    Examples: 
      | category L1 | category L2    | product       |
      | Pizza       | Single Topping | Sausage Pizza |
