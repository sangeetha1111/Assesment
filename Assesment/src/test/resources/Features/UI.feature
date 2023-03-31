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
@tag1
Feature: UI Validation
  I want to use this template for my feature file

  @UI
  Scenario: Request and Response Validation
  
    When Click
    Then RequestURL
    And Responsecode

  @UI1
  Scenario: Support button validation
   
    When Click
    Then SupportButton

  @UI2
  Scenario: OneTimePayment validation
   
    When Click
    Then Onetimepayment

  @UI3
  Scenario: MonthlySupport validation
   
    When Click
    Then Monthlysupport

  @UI4
  Scenario: Upgrade validation
   
    When Click
    Then Upgrade
   
    
