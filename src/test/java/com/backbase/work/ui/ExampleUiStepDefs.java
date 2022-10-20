package com.backbase.work.ui;

import com.backbase.work.common.ScenarioContext;
import com.backbase.work.ui.pages.SearchJobPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ExampleUiStepDefs {

  private final ScenarioContext scenarioContext;
  private WebDriver driver;

 public ExampleUiStepDefs(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
    this.driver = (WebDriver) this.scenarioContext.get(Keys.DRIVER);
  }

    @When("User select {string} location")
    public void userSelectLocation(String locationName) {
        SearchJobPage searchJobPage = new SearchJobPage(driver);
        searchJobPage.expandLocationDropdown()
                .selectKrakow();
    }

    @When("User select {string} as a function")
    public void userSelectAsAFunction(String locationName) {
        SearchJobPage searchJobPage = new SearchJobPage(driver);
        searchJobPage.expandFunctionDropdown()
                .selectQa();
    }

    @Then("In filter section appears {string} name")
    public void inFilterSectionAppearsName(String filterValue) {
        SearchJobPage searchJobPage = new SearchJobPage(driver);
        String displayedFilter = searchJobPage.getFilterValue();
        Assert.assertEquals(filterValue, displayedFilter);
    }
}
