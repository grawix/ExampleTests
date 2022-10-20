package com.backbase.work.ui;

import com.backbase.work.common.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

  private final ScenarioContext scenarioContext;

  public Hooks(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
  }

  @Before(order = 50, value = "@ui")
  public void driverSetup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-fullscreen");
    options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
    options.addArguments("--disable-extensions");
    scenarioContext.set(Keys.DRIVER, new ChromeDriver(options));
  }

  @After(order = 50, value = "@ui")
  public void driverTearDown() {
    WebDriver webDriver = (WebDriver) scenarioContext.get(Keys.DRIVER);
    webDriver.quit();
  }
}
