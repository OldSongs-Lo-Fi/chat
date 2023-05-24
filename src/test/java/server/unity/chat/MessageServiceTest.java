package server.unity.chat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import server.unity.chat.Entity.Message;
import server.unity.chat.Entity.User;
import server.unity.chat.ServiceInterface.MessageService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MessageServiceTest {

    @Autowired
    MessageService messageService;
    @Autowired
    PasswordEncoder passwordEncoder;
    private static List<Message> messages = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    @BeforeAll
    static void start(){

        PasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        //Users Adding
        users.add(new User("Lokus1", "Droid1", passwordEncoder1.encode("1111")));
        users.add(new User("Lokus2", "Droid2", passwordEncoder1.encode("2222")));
        users.add(new User("Lokus3", "Droid3", passwordEncoder1.encode("3333")));
        users.add(new User("Lokus4", "Droid4", passwordEncoder1.encode("4444")));
        users.add(new User("Lokus5", "Droid5", passwordEncoder1.encode("5555")));
        users.add(new User("Lokus6", "Droid6", passwordEncoder1.encode("6666")));



        messages.add(new Message(users.get(0), "Hello, Im 1 user!", "11:05"));
        messages.add(new Message(users.get(1), "Hello, Im 2 user!", "11:06"));
        messages.add(new Message(users.get(2), "Hello, Im 3 user!", "11:07"));
        messages.add(new Message(users.get(3), "Hello, Im 4 user!", "11:08"));
        messages.add(new Message(users.get(4), "Hello, Im 5 user!", "11:09"));
        messages.add(new Message(users.get(5), "Hello, Im 6 user!", "11:10"));

    }

    @Test
    void getMessagesSize(){
        messageService.createMessage(new Message(users.get(1), "Hello, Im 1 user!", "11:05"));
        messageService.createMessage(new Message(users.get(2), "Hello, Im 2 user!", "11:06"));
        messageService.createMessage(new Message(users.get(3), "Hello, Im 3 user!", "11:07"));
        messageService.createMessage(new Message(users.get(4), "Hello, Im 4 user!", "11:08"));
        messageService.createMessage(new Message(users.get(5), "Hello, Im 5 user!", "11:09"));
        assertEquals(6, messageService.getMessages().size());
    }

    @Test
    void deleteMessage(){

        assertEquals(true, messageService.deleteMessageById(1L));
    }

    @Test
    void incorrectDeleteMessage(){
        assertThrows(RuntimeException.class, () -> messageService.deleteMessageById(7L));
    }

    @Test
    void createMessage(){
        Message message = new Message(users.get(0), "texter", "12:34");
        assertEquals(message, messageService.createMessage(message));
    }
}
