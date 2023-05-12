package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static net.serenitybdd.rest.SerenityRest.filters;

public class Hooks {

    @Before(order=0)
    public void before() {
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
