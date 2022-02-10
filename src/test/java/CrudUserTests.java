import org.testng.annotations.Test;
import services.user.UserService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CrudUserTests {

    @Test(description = "Get users test")
    public void getUsersTest() {
        var response = UserService.getUsers();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getList("data").size()).isGreaterThan(1);
    }

    @Test(description = "Get users with delay test")
    public void getUsersWithDelayTest() {
        var response = UserService.getUsers(3);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getList("data").size()).isGreaterThan(1);
    }

    @Test(description = "Get user by ID test")
    public void getUserByIdTest() {
        var response = UserService.getUser("3");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("data.id")).isEqualTo("3");
    }

    @Test(description = "Get user by not existing ID test")
    public void getUserByNotExistIdTest() {
        var response = UserService.getUser("23");

        assertThat(response.statusCode()).isEqualTo(404);
    }

    @Test(description = "Delete user by ID test")
    public void deleteUserByIdTest() {
        var response = UserService.deleteUser("10");

        assertThat(response.statusCode()).isEqualTo(204);
    }
}
