package services.user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.User;
import services.BaseService;

import static helpers.EnvConfig.ENV_CONFIG;
import static io.restassured.RestAssured.given;

public class UserService extends BaseService {
    @Step
    public static Response createUser(final User user) {
        return given(requestSpec)
                .baseUri(ENV_CONFIG.getApiUrl())
                .basePath(ENV_CONFIG.registerPath())
                .when()
                .body(gson.toJson(user))
                .post()
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    @Step
    public static Response getUsers(final int delay) {
        return given(requestSpec)
                .baseUri(ENV_CONFIG.getApiUrl())
                .basePath(ENV_CONFIG.usersPath())
                .queryParam("delay", delay)
                .when()
                .get()
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public static Response getUsers() {
        return getUsers(0);
    }

    @Step
    public static Response getUser(final String id) {
        return given(requestSpec)
                .baseUri(ENV_CONFIG.getApiUrl())
                .basePath(ENV_CONFIG.userPath())
                .pathParam("id", id)
                .when()
                .get()
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    @Step
    public static Response deleteUser(final String id) {
        return given(requestSpec)
                .baseUri(ENV_CONFIG.getApiUrl())
                .basePath(ENV_CONFIG.userPath())
                .pathParam("id", id)
                .when()
                .delete()
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }
}
