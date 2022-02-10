import models.User;
import org.testng.annotations.Test;
import services.user.UserService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterUserTests {

    @Test(description = "Register user via API")
    public void registerApiTest() {
        final User userToCreate = new User(user -> {
            user.setEmail("eve.holt@reqres.in");
            user.setPassword("pistol");
        });

        var response = UserService.createUser(userToCreate);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("id")).isNotNull();
        assertThat(response.jsonPath().getString("token")).isNotNull();
    }

    @Test(description = "Register user via API without password")
    public void registerNegativeApiTest() {
        final User userToCreate = new User(user -> user.setEmail("eve.holt@reqres.in"));

        var response = UserService.createUser(userToCreate);

        assertThat(response.statusCode()).isEqualTo(400);
        assertThat(response.jsonPath().getString("error")).isEqualTo("Missing password");
    }
}
