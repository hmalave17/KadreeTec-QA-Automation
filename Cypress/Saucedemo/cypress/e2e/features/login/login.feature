Feature: Login functionality

  Scenario: login success
    Given user opens the website
    When user enters valid credentials
    Then system should display products page

  Scenario Outline: login wrong
    Given user opens the website
    When user enters username "<username>"
    Then system shows error "<message>"

    Examples:
      | username        | message                                                                   |
      | locked_out_user | Epic sadface: Sorry, this user has been locked out.                       |
      | hernan          | Epic sadface: Username and password do not match any user in this service |

  Scenario: username mandatory
    Given user opens the website
    When user does not enter username
    Then system shows required error

  Scenario: password mandatory
    Given user opens the website
    When user does not enter password
    Then system shows required error