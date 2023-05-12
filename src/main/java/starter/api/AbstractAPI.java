package starter.api;


import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import starter.configuration.CommonProps;

public abstract class AbstractAPI {

    public static final CommonProps PROPS = ConfigFactory.create(CommonProps.class);
    protected abstract RequestSpecification given();
}
