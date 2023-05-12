package starter.api;

import io.restassured.specification.RequestSpecification;

public class AbstractHerokuAppAPI extends AbstractAPI {
    @Override
    protected RequestSpecification given() {
        return ClientFactory.getClient().baseUri(PROPS.baseUrl());
    }
}
