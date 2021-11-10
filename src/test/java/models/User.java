package models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class User {
    private String email;
    private String password;
    private String id;
    private String token;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
