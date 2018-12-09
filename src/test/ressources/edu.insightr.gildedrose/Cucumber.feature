Feature: Conjured Item
  # a conjured item quality decreases twice the normal rate

  Scenario: conjured item update
    Given I have a new inventory
    Then the quality of the conjured item is 6
    When I update the inventory
    Then the quality of the conjured item is 4

  Scenario: Aged Brie item update
    Given I have a new inventory
    Then the quality of the Aged Brie item is 10
    When I update the inventory
    Then the quality of the  Aged Brie item is 11

  Scenario: date passed update
    Given I have a new inventory
    Then the quality of item is 10
    And the sellIn is 0
    When I update the inventory
    Then the quality of the item is 8

  Scenario: Quality never negative update
    Given I have a new inventory
    Then the quality of the item is 0
    When I update the inventory
    Then the quality of the item is 0

  Scenario: Never more than 50 update
    Given I have a new inventory
    Then the quality of the  item is 50
    When I update the inventory
    Then the quality of the item is 50

  Scenario: Sulfuras, Hand of Ragnaros item update
    Given I have a new inventory
    Then the quality of the Sulfuras, Hand of Ragnaros item is 150
    And the sellIn of the Sulfuras, Hand of Ragnaros item is 1000
    When I update the inventory
    Then the quality of the  Aged Brie item is 150
    And the sellIn of the Sulfuras, Hand of Ragnaros item is 1000

  Scenario: Quality never more than 50 update
    Given I have a new inventory
    Then the quality of the item is 50
    When I update the inventory
    Then the quality of the  Aged Brie item is 50

  Scenario: Backstage passes to a TAFKAL80ETC concert item update
    Given I have a new inventory
    Then the quality of the Backstage passes to a TAFKAL80ETC concert item is 12
    And  the sellIn of the Backstage passes to a TAFKAL80ETC concert item is 9
    When I update the inventory
    Then the quality of Backstage passes to a TAFKAL80ETC concert item is 14
    And  the sellIn of the Backstage passes to a TAFKAL80ETC concert item is 8

  Scenario: Backstage passes to a TAFKAL80ETC concert item update
    Given I have a new inventory
    Then the quality of the Backstage passes to a TAFKAL80ETC concert item is 14
    And  the sellIn of the Backstage passes to a TAFKAL80ETC concert item is 4
    When I update the inventory
    Then the quality of Backstage passes to a TAFKAL80ETC concert item is 17
    And  the sellIn of the Backstage passes to a TAFKAL80ETC concert item is 3




