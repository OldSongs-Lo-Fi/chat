package server.unity.chat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.unity.chat.Entity.Message;
import server.unity.chat.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findMessageById(Long id);
    List<Message> findMessagesByUser(User user);
    List<Message> findMessagesByTextContaining(String text);

}
