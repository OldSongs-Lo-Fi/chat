package server.unity.chat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.unity.chat.Entity.Message;
import server.unity.chat.Entity.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNickname(String nickname);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByLogin(String login);
    Optional<User> findUserByMessagesContaining(Message message);
    @Query("SELECT u.nickname FROM User u")
    Set<String> findAllNicknames();
}
