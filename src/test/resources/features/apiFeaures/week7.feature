Feature: week 7

  Scenario:  backend e2e from intellij
    Given user get Token
    When user create address
    Then assert if address is created
    When user update address json path
    When user update address hamcrest
    Then assert if address is updated
    When user delete address
    Then assert if address is deleted