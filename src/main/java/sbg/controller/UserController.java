package sbg.controller;

import sbg.domain.User;
import org.springframework.web.bind.annotation.*;
import sbg.service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by benoit on 04/08/15.
 */
@RestController
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid final User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User updateUser(@RequestBody @Valid final User user) {
        return userService.update(user.getId(),user.getPassword());
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }
}
