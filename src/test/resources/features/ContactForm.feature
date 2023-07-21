Feature: Contact Form Submission

  Scenario Outline: Submit the contact form
    Given I am on the contact form page
    And I accept the cookies
    And I initiate the contact form
    When I fill out the contact form with the following details:
      | Name   | Personal Code  | Case Number  | Phone Number  | Email     | Address   | Comments   |
      | <Name> | <PersonalCode> | <CaseNumber> | <PhoneNumber> | <Email>   | <Address> | <Comments> |
    And I submit the contact form
    And If the contact form was not successfully submitted I fill out the contact form again with the following details:
      | Name   | Personal Code  | Case Number  | Phone Number  | Email     | Address   | Comments   |
      | <Name> | <PersonalCode> | <CaseNumber> | <PhoneNumber> | <Email>   | <Address> | <Comments> |
    Then I should see a success message

    Examples:
      | Name | PersonalCode | CaseNumber | PhoneNumber | Email      | Address | Comments |
      | a    | 1            | 1          | 1           | j@e.com    | a       | t        |