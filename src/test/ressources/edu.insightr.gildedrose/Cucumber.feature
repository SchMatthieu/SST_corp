Feature: interface


  #items from the JSON files are add to list of items of the inventory

  Scenario: add item from the JSON file
    Given I have a new inventory
    Then the program display the items of the inventory
    When I read the JSON file
    Then the item has been add

  #the proportion of the pie chart are the same as the proprtion of each item of our inventory

  Scenario: the truthworthy of the pie chart
    Given I have a new inventory
    Then the pie chart is display
    When I add new items
    Then  the proportions of the pie chart change

  #the details of each item of the inventory have been updated when we push the button update

  Scenario: update button of the interface
    Given I have a new inventory
    Then the items are display
    When I push the update button
    Then the items have been update

  #if we add an item the there will be one item more displayed

  Scenario: add button of the interface
    Given I have a new inventory
    When I push the button add
    Then I have one more item in my inventory

 #if we delete an item the there will be one item less displayed

  Scenario: delete button of the interface
    Given I have a new inventory
    When I push the button delete
    Then I have one item less in my inventory




