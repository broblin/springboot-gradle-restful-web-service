package sbg.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import sbg.UserAlreadyExistsException;
import sbg.UserNotFoundException;
import sbg.domain.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by benoit on 04/08/15.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Inject
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(final User user) throws UserAlreadyExistsException {
        User existing = repository.findOne(user.getId());
        if (existing != null) {
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with id=%s", user.getId()));
        }
        return repository.save(user);
    }

    @Override
    @Transactional
    public User update(String id, String password) {
        User user = get(id);
        user.setPassword(password);
        repository.save(user);
        return user;
    }

    @Override
    public User get(String id) throws UserNotFoundException {
        User user = repository.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("No user with id=%s exists",id));
        }
        return user;
    }

    @Override
    @Transactional
    public User delete(String id) {
        User user = get(id);
        repository.delete(user);
        return user;
    }

    @Override
    public Page<User> findAll(Integer pageNumber, Integer pageSize) {
        //the 2 last parameters are optional
        return repository.findAll(new PageRequest(pageNumber,pageSize, Sort.Direction.ASC,"id"));
    }
}
