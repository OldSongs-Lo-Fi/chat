package server.unity.chat.Controllers;

import org.springframework.web.bind.annotation.*;
import server.unity.chat.Entity.Message;
import server.unity.chat.Entity.User;
import server.unity.chat.Facade.MessageFacade;
import server.unity.chat.Payload.DeleteMessage;
import server.unity.chat.Payload.MessagePayload;
import server.unity.chat.ServiceInterface.MessageService;
import server.unity.chat.ServiceInterface.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    final
    UserService userService;
    private final MessageService messageService;

    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<MessageFacade> getMessages(){
        List<Message> messages = messageService.getMessages();
        List<MessageFacade> messageFacades = new ArrayList<>();
        for (Message message:
                messages) {
            messageFacades.add(new MessageFacade(message.getUser().getNickname(), message.getText(), message.getDate()));
        }
        return messageFacades;
    }

    @GetMapping("/{id}")
    public MessageFacade getMessageById(@PathVariable("id") Long id){
        Message message = messageService.getMessageById(id);
        return new MessageFacade(message.getUser().getNickname(), message.getText(), message.getDate());
    }

    @GetMapping("/ofUser/{id}")
    public List<MessageFacade> getMessageByUserId(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        List<Message> messages = user.getMessages();
        List<MessageFacade> messageFacades = new ArrayList<>();
        for (Message message:
             messages) {
            messageFacades.add(new MessageFacade(user.getNickname(), message.getText(), message.getDate()));
        }
        return messageFacades;
    }



    @PostMapping("/create")
    public MessageFacade message(@RequestBody MessagePayload messagePayload){
        System.out.println("Start of creating message");
        Message message = new Message(
                userService.getUserById(messagePayload.getUserId()),
                messagePayload.getText(),
                messagePayload.getDate());
        System.out.println("End of creating message. \n New message: " + message.getText());
        Message created = messageService.createMessage(message);
        return new MessageFacade(created.getUser().getNickname(), created.getText(), created.getDate());
    }

    @PutMapping("/update")
    public MessageFacade updateMessage(@RequestParam("text") String text,
                                 @RequestParam("id") Long id){
        Message message = messageService.getMessageById(id);
        message.setText(text);
        Message updated = messageService.updateMessage(message);
        return new MessageFacade(updated.getUser().getNickname(), updated.getText(), updated.getDate());
    }

    @DeleteMapping("/delete/{id}")
    public DeleteMessage deleteMessageById(@PathVariable("id") Long id){
        return new DeleteMessage(messageService.deleteMessageById(id));
    }

}
