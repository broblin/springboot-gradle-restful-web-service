package sbg.service;

import sbg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by benoit on 04/08/15.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
