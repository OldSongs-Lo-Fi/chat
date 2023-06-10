package server.unity.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.unity.chat.entitys.Message;
import server.unity.chat.entitys.User;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findMessageById(Long id);
    List<Message> findMessagesByUser(User user);
    List<Message> findMessagesByTextContaining(String text);

}
