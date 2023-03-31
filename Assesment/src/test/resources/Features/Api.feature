#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: API Validation
  I want to use this template for my feature file

  @Get
  Scenario: LIST USERS
    Given Baseurl
    When get users
    Then I validate the outcomes

  @Get1
  Scenario: SINGLE USER
    When get specific user
    Then validate

  @Get2
  Scenario: SINGLE USER NOT FOUND
    When user not found
    Then Verify

  @POST
  Scenario: CREATE NEW USER
    Given headerinfo
    When create
    Then check

  @PUT
  Scenario: UPDATE USER
    Given update
    When updaterecord
    Then check1

  @DELETE
  Scenario: DELETE USER
    When delete
    Then check2
