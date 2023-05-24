package server.unity.chat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.unity.chat.Entity.Message;
import server.unity.chat.Entity.User;
import server.unity.chat.Repositories.MessageRepository;
import server.unity.chat.ServiceInterface.MessageService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceBasic implements MessageService {

    final
    MessageRepository messageRepository;

    public MessageServiceBasic(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message getMessageById(Long id) {
        Optional<Message> message = messageRepository.findMessageById(id);
        if (message.isPresent()) {
            return message.get();
        } else {
            throw new RuntimeException("Сообщение с указанным идентификатором не найдено");
        }
    }


    @Override
    public List<Message> getMessagesByUser(User user) {
        return messageRepository.findMessagesByUser(user);
    }

    @Override
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getMessagesSortedByDate() {
        List<Message> messages = messageRepository.findAll();
        messages.sort(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return messages;
    }

    @Override
    public List<Message> getMessagesThatContainsText(String text) {
        return messageRepository.findMessagesByTextContaining(text);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public boolean deleteMessage(Message message) {
        try {
            messageRepository.delete(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteMessageById(Long id) {
        Optional<Message> message = messageRepository.findMessageById(id);
        if (message.isPresent()) {
            messageRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Сообщение с указанным идентификатором не найдено");
        }
    }

    @Override
    public Message createMessage(User user, String text, String date) {
        Message message = new Message(user, text, date);
        return messageRepository.save(message);
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}