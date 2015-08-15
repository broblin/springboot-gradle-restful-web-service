package sbg.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbg.Launcher;
import sbg.domain.User;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * Created by benoit on 15/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Launcher.class)
public class UserServiceImplIntegrationTest {

    @Inject
    UserService userService;

    @Test
    public void shouldFindAllUser(){
        //given
        List<String> ids = Arrays.asList("test1", "test2", "test3", "test4", "test5");
        ids.stream().forEach(id -> userService.save(createUser(id)));

        //when
        Page<User> paginatedList =  userService.findAll(1, 2);

        //then
        assertNotNull(paginatedList);
        assertTrue(paginatedList.hasContent());
        assertEquals(3,paginatedList.getTotalPages());
        assertEquals(5, paginatedList.getTotalElements());
        assertArrayEquals(new String[]{"test3", "test4"}, paginatedList.getContent().stream().map(User::getId).collect(Collectors.toList()).toArray());
    }

    private User createUser(String id){
        User user = new User();
        user.setId(id);
        user.setPassword("test");
        return user;
    }
}
