package server.unity.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.unity.chat.entitys.Message;
import server.unity.chat.entitys.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNickname(String nickname);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByLogin(String login);
    Optional<User> findUserByMessagesContaining(Message message);
    List<User> findAllByOrderByNicknameAsc();
    //TODO DROP DATABASE --
    @Query("SELECT u.nickname FROM User u")
    Set<String> findAllNicknames();
}
