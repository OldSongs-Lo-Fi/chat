package server.unity.chat.services.interfaces;

import server.unity.chat.entitys.Message;
import server.unity.chat.entitys.User;

import java.util.List;

public interface MessageService {
    public Message getMessageById(Long id);
    public List<Message> getMessagesByUser(User user);
    public List<Message> getMessages();
    public List<Message> getMessagesSortedByDate();
    public List<Message> getMessagesThatContainsText(String text);
    public Message updateMessage(Message message);
    public boolean deleteMessage(Message message);
    public boolean deleteMessageById(Long id);
    public Message createMessage(User user, String text, String date);
    public Message createMessage(Message message);
}
