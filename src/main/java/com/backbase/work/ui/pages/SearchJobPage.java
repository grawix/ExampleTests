package com.backbase.work.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchJobPage extends BasePage {

    private final By locationDropdownLocator = By.cssSelector(".total__filter--location+i");
    private final By krakowLocationLocator = By.cssSelector(".job__filter.active .filter:nth-child(1)");
    private final By functionDropdownLocator = By.cssSelector(".total__filter--subcategory");
    private final By qaLocationLocator = By.cssSelector(".job__filter.active [value=QA]+span");
    private final By currentFilterLocation = By.cssSelector(".currentfilter");

    public SearchJobPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchJobPage expandLocationDropdown() {
        getElement(locationDropdownLocator).click();
        return this;
    }

    public SearchJobPage expandFunctionDropdown() {
        getElement(functionDropdownLocator).click();
        return this;
    }

    public SearchJobPage selectKrakow() {
        getElement(krakowLocationLocator).click();
        return this;
    }

    public SearchJobPage selectQa() {
        getElement(qaLocationLocator).click();
        return this;
    }

    public String getFilterValue() {
        return getElement(currentFilterLocation).getText();
    }
}

