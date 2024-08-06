package StepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SogetiApiSteps {
    private Response response;

    @Given("I send a GET request to the Zippopotam API")
    public void iSendAGETRequestToTheZippopotamAPI() {
        RestAssured.baseURI = "http://api.zippopotam.us";
        response = given().when().get("/de/bw/stuttgart");
    }

    @And("verify response country is {string} and state {string}")
    public void verifyResponseCountryIsAndState(String expectedCountry, String expectedState) {
        String actualCountry = response.jsonPath().getString("country");
        Assert.assertEquals(actualCountry,expectedCountry);

        String actualState = response.jsonPath().getString("state");
        Assert.assertEquals(actualState,expectedState);
    }

    @Then("verify response for {string} and place name has {string}")
    public void verifyResponsePostCodeIsAndPlaceNameHas(String postCode, String expectedPlace) {
        String actualPlace = response.jsonPath().getString("places.find { it.'post code' == '" + postCode + "' }.'place name'");
        Assert.assertEquals(actualPlace,expectedPlace);
    }


    @Given("I send a GET request to the API with {string} and postal code {string}")
    public void iSendAGETRequestToTheAPIWithAndPostalCode(String country, String postalCode) {
        RestAssured.baseURI = "http://api.zippopotam.us";
        response = given().when().get("/" + country + "/" + postalCode);
    }

    @Then("the response status code should be 200, content type in JSON and  response time lessthan 1sec")
    public void the_response_status_code_should_be_200() {
        response.then().statusCode(200);
        response.then().contentType("application/json");
        response.then().time(lessThan(3000L));
    }

    @And("the place name should be {string}")
    public void thePlaceNameShouldBe(String placeName) {
        String actualPlaceName = response.jsonPath().getString("places[0].'place name'");
        Assert.assertEquals(placeName, actualPlaceName);
    }
}
