package sbg.service;

import sbg.UserAlreadyExistsException;
import sbg.UserNotFoundException;
import sbg.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by benoit on 04/08/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    public static final String TEST_ID = "test";
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void shouldSaveNewUser() {
        final User savedUser = stubRepositoryToReturnUserOnSave();
        final User user = new User();
        final User returnedUser = userService.save(user);
        // verify repository was called with user
        verify(userRepository, times(1)).save(user);
        assertEquals("Returned user should come from the repository", savedUser, returnedUser);
    }

    private User stubRepositoryToReturnUserOnSave() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        return user;
    }

    @Test
    public void shouldSaveNewUser_GivenThereExistsOneWithTheSameId_ThenTheExceptionShouldBeThrown() throws Exception {
        stubRepositoryToReturnExistingUser();
        Exception anException = null;
        try {
            userService.save(createUser());
            fail("Expected exception");
        } catch (UserAlreadyExistsException ignored) {
            anException = ignored;
        }
        verify(userRepository, never()).save(any(User.class));
        assertNotNull(anException);
    }

    @Test
    public void shouldGetUser_AnExceptionShouldBeTrownIfNotExist(){
        stubRepositoryToReturnExistingUser();
        User user = userService.get(TEST_ID);
        assertNotNull(user);
        assertEquals(TEST_ID, user.getId());

        Exception anException = null;
        try {
            userService.get("not_exists");
            fail("Expected exception");
        } catch (UserNotFoundException ignored) {
            anException = ignored;
        }
        assertNotNull(anException);
    }

    private void stubRepositoryToReturnExistingUser() {
        User user = createUser();
        when(userRepository.findOne(user.getId())).thenReturn(user);
    }

    private User createUser(){
        User user = new User();
        user.setId(TEST_ID);
        user.setPassword("test");
        return user;
    }
}
