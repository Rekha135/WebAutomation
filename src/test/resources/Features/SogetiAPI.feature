Feature: Sogeti API

  @testcase1 @test
  Scenario: Verify Zippopotam API for Germany
    Given I send a GET request to the Zippopotam API
    When the response status code should be 200, content type in JSON and  response time lessthan 1sec
    And verify response country is "Germany" and state "Baden-Württemberg"
    Then verify response for "70597" and place name has "Stuttgart Degerloch"

  @testcase2  @test
  Scenario Outline: Verify Place Name for given Country and Postal Code
    Given I send a GET request to the API with "<Country>" and postal code "<Postal Code>"
    And the response status code should be 200, content type in JSON and  response time lessthan 1sec
    Then the place name should be "<Place Name>"
    Examples:
      | Country | Postal Code | Place Name    |
      | us      | 90210       | Beverly Hills |
      | us      | 12345       | Schenectady   |
      | ca      | B2R         | Waverley      |

