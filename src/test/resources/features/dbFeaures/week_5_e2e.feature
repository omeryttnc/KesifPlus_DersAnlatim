Feature: week 5 database

  @MDB
  Scenario: database e2e testi with statement
    When user create account with statement
    Then we should be able to see account created in database with statement
    When user update account with statement
    Then we should be able to see account updated in database with statement
    When user delete account with statement
    Then we should be able to see account deleted in database with statement

  @MDB
  Scenario: database e2e testi with preparedStatement
    When user create account with preparedStatement
    Then we should be able to see account created in database with preparedStatement
    When user update account with preparedStatement
    Then we should be able to see account updated in database with preparedStatement
    When user delete account with preparedStatement
    Then we should be able to see account deleted in database with preparedStatement


    