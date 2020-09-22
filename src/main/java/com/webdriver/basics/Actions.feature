Feature: Mouse & Keyboard related scenarios
Background: Common Steps
Given Actions I navigate to the url "https://demos.telerik.com/kendo-ui/dragdrop/events"

Scenario: Context Click Handling
When Actions I perform the context click
And Actions I take the screenshot
Then Actions I call the quit method to close the browser

Scenario: Working with drag & drop action
When Actions I perform the drag & drop action
Then Actions I call the quit method to close the browser

Scenario: Working with click & hold
When Actions I perform the click & hold action
Then Actions I call the quit method to close the browser

Scenario: Working with Keyboard actions
When Actions I perform the Keyboard actions
Then Actions I call the quit method to close the browser