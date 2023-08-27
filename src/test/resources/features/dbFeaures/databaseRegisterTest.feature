Feature:

  @MDB @UI
  Scenario:
#    Given user connects to the database
    When user registers through UI
    Then user verifies registered user exists in the database
    And user verifies following column names are present in the users table
      | userid    |
      | email     |
      | password |
    And user verifies all emails are unique
#    When user closes the connection
