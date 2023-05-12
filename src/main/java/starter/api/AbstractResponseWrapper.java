package starter.api;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import lombok.SneakyThrows;

import org.hamcrest.Matcher;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class AbstractResponseWrapper<T> {
    private static final String DEFAULT_STATUS_CODE_ERROR = "Wrong status code!";
    private static final int RESPONSE_CODE_300 = 300;
    private static final int RESPONSE_CODE_400 = 400;
    private static final int RESPONSE_CODE_500 = 500;

    private final ValidatableResponse response;
    @Getter
    private static ValidatableResponse latestResponse;

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<Type> type;

    protected AbstractResponseWrapper(Response response) {
        this.response = response.then();
        latestResponse = this.response;
        setTypeRef();
    }

    public static <T> T getLatestResponse(Class<T> bodyType) {
        return latestResponse.extract().body().as(bodyType);
    }

    private void setTypeRef() {
        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            this.type = Optional.empty();
        } else {
            this.type = Optional
                    .ofNullable(((ParameterizedType) superClass).getActualTypeArguments()[0]);
        }
    }
/*
    public T asDto() throws HttpException {
        expectStatusOk();
        return response.extract().body().as(type
                .orElseThrow(
                        () -> new NullPointerException("Return type not defined for ResponseWrapper")));
    }
    @SneakyThrows
    public AbstractResponseWrapper<T> expectStatusOk() {
        validateResponseCode(DEFAULT_STATUS_CODE_ERROR, lessThan(RESPONSE_CODE_300));
        return this;
    }


    public AbstractResponseWrapper<T> expectStatusBadRequest() throws HttpException {
        validateResponseCode(DEFAULT_STATUS_CODE_ERROR, equalTo(RESPONSE_CODE_400));
        return this;
    }

    private void validateResponseCode(String errorMessage,
                                      Matcher<? super Integer> expectedStatusCode) throws HttpException {
        if (response.extract().statusCode() >= RESPONSE_CODE_500) {
            throw new HttpException(response.extract().body().asString());
        }
        try {
            response.statusCode(expectedStatusCode);
        } catch (AssertionError error) {
            throw new HttpException(errorMessage, error);
        }
    }*/
}
