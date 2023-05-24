package server.unity.chat.Facade;

public class MessageFacade {
    private String nickname;
    private String text;
    private String date;

    public MessageFacade(String nickname, String text, String date) {
        this.nickname = nickname;
        this.text = text;
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
