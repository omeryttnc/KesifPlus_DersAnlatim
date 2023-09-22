Feature: admin api

  Scenario:
    Given user logs in as an admin
    When admin gets users list
    And user gets the number of users
    And admin chooses a user
    And admin deletes a user
    Then admin verifies user is deleted
    When admin gets users list
    Then admin verifies the number of users
