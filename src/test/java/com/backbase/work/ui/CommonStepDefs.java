package com.backbase.work.ui;

import com.backbase.work.common.ScenarioContext;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonStepDefs {

  private final ScenarioContext scenarioContext;

  public CommonStepDefs(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
  }

  @Given("User is on the workatbackbase.com")
  public void userIsOnTheWorkAtBackbaseCom() {
    ((WebDriver) this.scenarioContext.get(Keys.DRIVER)).navigate().to("https://workatbackbase.com/jobs/");
    ((WebDriver) this.scenarioContext.get(Keys.DRIVER)).findElement(By.cssSelector(".CookieDialog button")).click();
  }
}
