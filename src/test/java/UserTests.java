import models.User;
import org.testng.annotations.Test;
import services.user.UserService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTests {

    @Test(description = "Register user via API")
    public void registerApiTest() {
        final User userToCreate = new User("eve.holt@reqres.in", "pistol");
        final User user = new UserService().createUser(userToCreate);

        assertThat(user.getToken())
                .as("User created via API should have token")
                .isNotNull();
        assertThat(user.getId())
                .as("User created via API should have id")
                .isNotNull();
    }
}
