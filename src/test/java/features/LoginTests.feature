Feature: Login Tests

    Background:
        Given User is in Login Page

    @Login @ValidLogin
    Scenario Outline: Check user can log in only with valid credentials

        Given User enters username <username> and password <password>
        When User clicks on Login button
        Then User should be able to log in

        Examples:

            | username                  | password          |
            | standard_user             | secret_sauce      |
            | problem_user              | secret_sauce      |
            | performance_glitch_user   | secret_sauce      |

    @Login @InvalidLogin
    Scenario Outline: Check user cannot log in with invalid credentials
    
        Given User enters username <username> and password <password>
        When User clicks on Login button
        Then User should not be able to log in and should see this error message: <error_msg>

        Examples:

            | username          | password          | error_msg                                                   |
            | locked_out_user   | secret_sauce      | Sorry, this user has been locked out.                       |
            | standard_user     | invalid_password  | Username and password do not match any user in this service |