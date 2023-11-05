package seminars.third.hw;

import org.junit.Before;
import org.junit.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.junit.Assert.*;

public class UserRepositoryTest {
    private UserRepository userRepository;
    private User admin1;
    private User admin2;
    private User nonAdmin1;
    private User nonAdmin2;

    @Before
    public void setUp() {
        userRepository = new UserRepository();
        admin1 = new User("Admin1", "admin123", true);
        admin2 = new User("Admin2", "admin456", true);
        nonAdmin1 = new User("User1", "user123", false);
        nonAdmin2 = new User("User2", "user456", false);

        userRepository.addUser(admin1);
        userRepository.addUser(admin2);
        userRepository.addUser(nonAdmin1);
        userRepository.addUser(nonAdmin2);

        admin1.authenticate("Admin1", "admin123");
        admin2.authenticate("Admin2", "admin456");
        nonAdmin1.authenticate("User1", "user123");
        nonAdmin2.authenticate("User2", "user456");
    }

    @Test
    public void testLogoutNonAdminUsersAndRemoveThemFromRepository() {
        assertEquals(4, userRepository.data.size());

        userRepository.logOutNonAdmins();

        assertTrue(admin1.isAuthenticate);
        assertTrue(admin2.isAuthenticate);
        assertFalse(nonAdmin1.isAuthenticate);
        assertFalse(nonAdmin2.isAuthenticate);

        assertEquals(2, userRepository.data.size()); // Должны остаться только админы
        assertTrue(userRepository.data.contains(admin1));
        assertTrue(userRepository.data.contains(admin2));
        assertFalse(userRepository.data.contains(nonAdmin1));
        assertFalse(userRepository.data.contains(nonAdmin2));
    }
}



