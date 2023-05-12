package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import starter.api.cars.CarsAPI;
import starter.api.cars.get.response.GetCarsResponseItem;

import java.util.Arrays;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchStepDefinitions {

    @Steps
    public CarsAPI carsAPI;

    @When("user calls GET endpoint for {string}")
    public void userCallsGetEndpoint(String product) {
        carsAPI.getProduct(product);
    }

    @Then("user sees the results displayed for {string}")
    public void userSeesTheResultsDisplayedFor(String product) {
        Assertions.assertThat(Arrays.stream(SerenityRest.lastResponse()
                                .body()
                                .as(GetCarsResponseItem[].class))
                        .anyMatch(item -> item.getTitle().toLowerCase().contains(product.toLowerCase())))
                .as("Some items don't contain %s product", product).isTrue();
        }

    @Then("user does not see the results")
    public void userDoesNotSeeTheResults() {
        restAssuredThat(response -> response.statusCode(404)
                .body("detail.error", equalTo(true)));
    }
}
