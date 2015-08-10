package sbg.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by benoit on 04/08/15.
 */
@Entity
public class User {
    @NotNull
    @Size(max = 64)
    @Id
    private String id;

    @NotNull
    @Size(max = 64)
    private String password;

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
