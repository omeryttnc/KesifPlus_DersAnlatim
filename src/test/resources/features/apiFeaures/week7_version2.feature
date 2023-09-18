Feature: week 7

  Scenario:  backend e2e from intellij
    Given user get Token version
    When user create address version
    Then assert if address is created version
    When user update address json path version
    When user update address hamcrest version
    Then assert if address is updated version
    When user delete address version
    Then assert if address is deleted version