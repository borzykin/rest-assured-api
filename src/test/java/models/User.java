package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Data
@Accessors(chain = true)
public class User {
    private String email;
    private String password;
    private String id;
    private String token;

    public User(final Consumer<User> builder) {
        requireNonNull(builder).accept(this);
    }
}
