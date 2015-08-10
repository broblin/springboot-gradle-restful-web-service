package sbg;

/**
 * Created by benoit on 07/08/15.
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
