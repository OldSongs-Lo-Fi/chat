package server.unity.chat.payloads;

public class MessagePayload {
    private String text;
    private String date;
    private Long userId;

    public MessagePayload(String text, String date, Long userId) {
        this.text = text;
        this.date = date;
        this.userId = userId;
    }

    public MessagePayload() {
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
