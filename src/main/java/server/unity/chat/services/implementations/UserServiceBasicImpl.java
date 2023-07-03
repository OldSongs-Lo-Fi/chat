package server.unity.chat.services.implementations;

import org.springframework.stereotype.Service;
import server.unity.chat.entitys.Message;
import server.unity.chat.entitys.User;
import server.unity.chat.repositories.UserRepository;
import server.unity.chat.services.interfaces.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceBasicImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceBasicImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override public User getUserById(Long id) {
        return userRepository.findUserById(id).orElse(null);
    }


    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByNickname(name).orElse(null);
    }

    @Override
    public User getUserByMessage(Message message) {
        return userRepository.findUserByMessagesContaining(message).orElse(null);
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
        return userRepository.findAllByOrderByNicknameAsc();
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
