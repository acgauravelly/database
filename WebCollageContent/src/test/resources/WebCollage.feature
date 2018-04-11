@All
Feature: WC content

  @wc
  Scenario Outline: Filter WC content

    Given I visit a "<url>"
    And I export the harfile
    Then the search for webcollage content should be "<Result>"

    Examples:

      | url                                                                                                  | Result |
      | http://www.stoehr-diskont.at/i/samsung-addwash-ww8ak44205w-136527/                              | FALSE  |
#      | https://plazalama.com/tv-led-samsung-m-un88js9500f-88-cvo-uhd.html/                               | FALSE  |
#      | http://www.alshop.com/samsung-galaxy-note-4-32gb-lte-smartphone-n910c-charcoal-black.html            | FALSE  |
      | https://baybloorradio.com/samsung-55quot-q7f-qled-4k-tv                                              | TRUE   |
#      | https://gibbyselectronicsupermarket.ca/product/samsung-hw-k950-5-1-4-500w-soundbar-with-dolby-atmos/ | TRUE   |
