Feature: Login

@login
Scenario: Login with valid credentials
  Given User selects login option
  When Login to the ecommerce application using username "test123" and password "T@ilofalion89"
  Then Verify login profile


@login
Scenario: Login with invalid credentials
  Given User selects login option
  When Login to the ecommerce application using username "test12345" and password "Tailofalion89"
  Then Verify error message "Please enter a correct username and password. Note that both fields may be case-sensitive."