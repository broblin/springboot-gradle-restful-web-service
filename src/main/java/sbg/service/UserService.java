package sbg.service;

import org.springframework.data.domain.Page;
import sbg.UserAlreadyExistsException;
import sbg.domain.User;

/**
 * Created by benoit on 04/08/15.
 */
public interface UserService {
    User save(User user);

    User update(String id,String password);

    User get(String id);

    User delete(String id);

    Page<User> findAll(Integer pageNumber,Integer pageSize);
}
