Feature: Test cases for epam.com

  Scenario: Website epam.com is loading home page
    Given we know the website URL
    When we go to "https://www.epam.com/"
    Then home page is loading

  Scenario: Opens the list of offices in the USA
    Given we are on the main page of website in the section "Our offices"
    When we push the button "United States"
    Then opens list of offices in the USA

  Scenario: Animation on the page "https://www.epam.com/services" works
    Given we are on the page "https://www.epam.com/services"
    When we scroll till the animation
    Then the animation is always working

  Scenario: Button CONTACT US works
    Given we are on the main page of website
    When we push the button CONTACT US
    Then system is redirect us on the page https://www.epam.com/about/who-we-are/contact

  Scenario: List "LOCATION" opens
    Given we are on the page https://www.epam.com/careers
    When we push to open list "All Cities in Ukraine"
    Then the list opens right

  Scenario: List "SKILLS" opens
    Given we are on the page https://www.epam.com/careers
    When we push to open list "All Skills"
    Then the list opens right

  Scenario: Return to home page works
    Given we are on any page of the website
    When we push the button "EPAM"
    Then system is redirect us on the page https://www.epam.com/

  Scenario Outline: The website have localization
    Given we are on the main page of website
    When we push "Global (EN)", then "{language}"
    Then site show us full page localized to "{language}"
    Examples:
      |          language          |
      |    Україна (Українська)    |
      |    DACH(Deutsch)           |
      |    Polska (Polski)         |
