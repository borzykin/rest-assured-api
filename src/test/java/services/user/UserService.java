package services.user;

import com.google.gson.Gson;
import models.User;
import services.BaseService;

import static io.restassured.RestAssured.given;

public class UserService extends BaseService {
    private final Gson gson = new Gson();

    public User createUser(final User user) {
        return given(requestSpec)
                .when()
                .body(gson.toJson(user))
                .post("api/register")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract()
                .body()
                .as(User.class);
    }
}
