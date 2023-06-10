package server.unity.chat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import server.unity.chat.entitys.User;
import server.unity.chat.repositories.UserRepository;
import server.unity.chat.services.implementations.UserServiceBasicImpl;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserServiceBasicImplTest {

    private UserServiceBasicImpl userService;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Инициализация моков

        userService = new UserServiceBasicImpl(mockUserRepository);
    }

    @Test
    public void testGetUserById_UserExists() {
        Long userId = 1L;
        User expectedUser = new User("Johan", "John", "john@example.com");

        when(mockUserRepository.findUserById(userId)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.getUserById(userId);

        Assertions.assertEquals(expectedUser, actualUser);
        verify(mockUserRepository, times(1)).findUserById(userId);
    }

    @Test
    public void testGetUserById_UserNotExists() {
        long userId = 1L;

        when(mockUserRepository.findUserById(userId)).thenReturn(Optional.empty());

        User actualUser = userService.getUserById(userId);

        Assertions.assertNull(actualUser);
        verify(mockUserRepository, times(1)).findUserById(userId);
    }

    @Test
    public void testGetUserByName_UserExists() {
        String name = "John";
        User expectedUser = new User("Johan", name, "john@example.com");

        when(mockUserRepository.findUserByNickname(name)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.getUserByName(name);

        Assertions.assertEquals(expectedUser, actualUser);
        verify(mockUserRepository, times(1)).findUserByNickname(name);
    }

    @Test
    public void testGetUserByName_UserNotExists() {
        String name = "John";

        when(mockUserRepository.findUserByNickname(name)).thenReturn(Optional.empty());

        User actualUser = userService.getUserByName(name);

        Assertions.assertNull(actualUser);
        verify(mockUserRepository, times(1)).findUserByNickname(name);
    }
}
