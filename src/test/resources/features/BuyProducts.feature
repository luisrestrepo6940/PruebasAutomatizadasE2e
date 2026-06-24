#language: en

Feature: buy products on the website

  @check-product-purchase
  Scenario Outline: check product purchase

    Given the user accesses to the website
    And the user logs in with username "<user>" and password "<password>"
    When the user adds "<productsQuantity>" products to the cart
    Then user should be able to complete the purchase successfully
      | firstName   | lastName   | postalCode   | productsQuantity   | confirmationMessage   |
      | <firstName> | <lastName> | <postalCode> | <productsQuantity> | <confirmationMessage> |

    Examples:
      | user          | password     | productsQuantity | firstName | lastName | postalCode | confirmationMessage       |
      | standard_user | secret_sauce | 2                | Josue     | Presley  | 5105       | Thank you for your order! |













































