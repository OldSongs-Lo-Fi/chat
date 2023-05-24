package server.unity.chat.Payload;

public class MessagePayload {
    private String text;
    private String date;
    private Long user_id;

    public MessagePayload(String text, String date, Long user_id) {
        this.text = text;
        this.date = date;
        this.user_id = user_id;
    }

    public MessagePayload() {
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
