Feature: Framework utility functions functions to be reused

Scenario:
  * def uuid = function(){ return java.util.UUID.randomUUID() + '' };
  * def now =
    """
      function() {
        return java.time.LocalDate.now();
      }
    """
