package starter.api.cars;

import io.restassured.response.ValidatableResponse;
import starter.api.AbstractHerokuAppAPI;

public class CarsAPI extends AbstractHerokuAppAPI {


    public ValidatableResponse getProduct(String product) {
                return given()
                        .get(Endpoint.GET_PRODUCT, product).then();
    }

    private static final class Endpoint {
        public static final String GET_PRODUCT = "/api/v1/search/demo/{product}";
    }

}
