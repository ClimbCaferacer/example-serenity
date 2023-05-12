Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/demo/{product} for getting the products.
### Available products: "orange", "apple", "pasta", "cola"
### Prepare Positive and negative scenarios

  Scenario Outline: Search product positive
    When user calls GET endpoint for "<product>"
    Then user sees the results displayed for "<product>"
    Examples:
    |product    |
    |apple      |
    |orange     |
    |pasta      |
    |cola       |

  Scenario: Search product negative
    When user calls GET endpoint for "car"
    Then user does not see the results
