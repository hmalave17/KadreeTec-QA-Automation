Feature: login to webside

    Scenario: login successful
        Given user open webside
        When user into her data
        Then system show webside

    Scenario Outline: login wrong
        Given user open webside
        When user into her data '<username>'
        Then system show error '<message>'
        Examples:
            | username        | message                                                                   |
            | locked_out_user | Epic sadface: Sorry, this user has been locked out.                       |
            | hernan          | Epic sadface: Username and password do not match any user in this service |

    Scenario: username mandatory
        Given user open webside
        When user doesnot send username
        Then system show error

    Scenario: password mandatory
        Given user open webside
        When user doesnot send password
        Then system show error
