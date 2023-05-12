package starter.api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class ClientFactory {

    public static RequestSpecification getClient() {
        return SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .redirects().follow(false);
    }
}
