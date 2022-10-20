package com.backbase.work.api;

import com.backbase.work.ui.ScenarioContext;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ExampleApiStepDefs {
  private final ScenarioContext scenarioContext;

  public ExampleApiStepDefs(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
  }

  @When("user send request with query parameter {string} and value {string} to retrieve activity")
  public void userSendRequestWithQueryParameterParticipant(String parameter, String value) {
    Response response = given().queryParam(parameter, value)
            .when().get("https://www.boredapi.com/api/activity");

    this.scenarioContext.set(Keys.RESPONSE, response);
  }

  @Then("retrieved activity has participants equals {string}")
  public void retrievedActivityHasParticipantsEquals(String value) {
    Response response = (Response)scenarioContext.get(Keys.RESPONSE);
    Gson gson = new Gson();
    Activity activity = new Activity();
    Assert.assertEquals(Integer.parseInt(value), activity.getParticipants());
  }
}
