package server.unity.chat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.unity.chat.Entity.Message;
import server.unity.chat.Entity.User;
import server.unity.chat.Repositories.UserRepository;
import server.unity.chat.ServiceInterface.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceBasic implements UserService {

    final
    UserRepository userRepository;

    public UserServiceBasic(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findUserById(id);
        return user.orElse(null);
    }

    @Override
    public User getUserByName(String name) {
        Optional<User> user = userRepository.findUserByNickname(name);
        return user.orElse(null);
    }

    @Override
    public User getUserByMessage(Message message) {
        Optional<User> user = userRepository.findUserByMessagesContaining(message);
        return user.orElse(null);
    }

    @Override
    public Set<String> getUsersNicknames() {
        return userRepository.findAllNicknames();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersSortedByName() {
        List<User> users = getUsers();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getNickname().compareTo(o2.getNickname());
            }
        });
        return users;
    }

    @Override
    public List<User> getUsersSortedByMessageCount() {
        List<User> users = getUsers();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getMessages().size() - o2.getMessages().size();
            }
        });
        return users;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        Optional<User> user = userRepository.findUserById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Сообщение с указанным идентификатором не найдено");
        }
    }

    @Override
    public User createUser(String password, String login, String nickname) {
        return userRepository.save(new User(nickname, login, password));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
