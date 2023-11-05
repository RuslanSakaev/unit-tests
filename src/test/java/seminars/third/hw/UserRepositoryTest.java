package seminars.third.hw;

import org.junit.Before;
import org.junit.Test;
import org.example.seminars.third.tdd.User;
import org.example.seminars.third.tdd.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    public void testLogoutNonAdminUsersAndRemoveThemFromRepository() {
        User admin1 = new User("Admin1", "admin123", true);
        User admin2 = new User("Admin2", "admin456", true);
        User nonAdmin1 = new User("User1", "user123", false);
        User nonAdmin2 = new User("User2", "user456", false);

        // Аутентификация пользователей
        admin1.authenticate("Admin1", "admin123");
        admin2.authenticate("Admin2", "admin456");
        nonAdmin1.authenticate("User1", "user123");
        nonAdmin2.authenticate("User2", "user456");

        // Добавление пользователей в репозиторий
        userRepository.addUser(admin1);
        userRepository.addUser(admin2);
        userRepository.addUser(nonAdmin1);
        userRepository.addUser(nonAdmin2);

        // Проверка начального количества пользователей
        assertEquals(4, userRepository.data.size());

        // Выполнение операции разлогинивания неадминистраторов
        userRepository.logOutNonAdmins();

        // Проверка, что неадминистраторы удалены из репозитория
        assertFalse(userRepository.findByName("User1"));
        assertFalse(userRepository.findByName("User2"));

        // Проверка, что неадминистраторы разлогинены
        assertFalse(nonAdmin1.isAuthenticate);
        assertFalse(nonAdmin2.isAuthenticate);

        // Проверка конечного количества пользователей
        assertEquals(2, userRepository.data.size());
    }
}