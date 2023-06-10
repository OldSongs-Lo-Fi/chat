package server.unity.chat.facade;

import server.unity.chat.entitys.Message;

import java.util.List;

public class UserFacade {

    private String nickname;
    private List<Message> messages;

    public UserFacade(String nickname, List<Message> messages) {
        this.nickname = nickname;
        this.messages = messages;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
