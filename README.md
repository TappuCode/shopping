# shopping Project

<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#project-details">Project Details</a>
      <ul>
        <li><a href="#framework-used">Framework used</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#test-design-details">Test Design Details</a></li>
    <li><a href="#test-result">Test Execution Result</a></li>
</ol>
</details>

## Project Details
This is Selenium Demo automation project. I have used [Page object model](https://www.selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/) design pattern and PageFactory. Project can build using maven. These selenium tests can be run using TestNG testing framework. I have made assumption that user account already existing and add details in config property file

### Framework used
I have used following major framework to build this project.
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/)
* [TestNG](https://testng.org/doc/)
* [Java](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/what-is-corretto-8.html)

## Getting Started

### Prerequisites

* [Java](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html)
* [Eclipse IDEA](https://www.eclipse.org/downloads/) - (This is not must but good to have)
* [Maven](https://maven.apache.org/users/index.html)
* [ChromeDriver](https://chromedriver.chromium.org/downloads)

### Installation 
  ```sh
  git clone https://github.com/TappuCode/shopping.git
  mvn clean test
  ```

Or

Open project from Eclipse and run testng.xml

### Test Design Details

I have created 5 Page Object class and 5 Test call to test each page
* LoginPage
* ProductCatalogue
* CartActions
* CartPage
* CheckoutAction

## Config File
[Config property file](https://github.com/TappuCode/shopping/blob/main/shopping/src/main/java/com/seleniumdemo/automation/shopping/config/config.properties) is under shopping\shopping\src\main\java\com\seleniumdemo\automation\shopping\config folder

## Test Execution Result

![Test Execution Result](https://github.com/TappuCode/shopping/blob/main/shopping/src/main/java/com/seleniumdemo/automation/shopping/resource/ExecutionResult.PNG)
