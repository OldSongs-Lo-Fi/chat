package server.unity.chat.ServiceInterface;

import server.unity.chat.entity.Message;
import server.unity.chat.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User getUserById(Long id);
    public User getUserByName(String name);
    public User getUserByMessage(Message message);
    public Set<String> getUsersNicknames();
    public List<User> getUsers();
    public List<User> getUsersSortedByName();
    public List<User> getUsersSortedByMessageCount();
    public User updateUser(User user);
    public boolean deleteUser(User user);
    public boolean deleteUserById(Long id);
    public User createUser(String password, String login, String nickname);
    public User createUser(User user);
}
