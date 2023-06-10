package server.unity.chat.payloads;

public class MessagePayload {
    private String text;
    private String date;
    private Long userId;
    private String sound;
    private String image;

    public MessagePayload(String text, String date, Long userId, String sound, String image) {
        this.text = text;
        this.date = date;
        this.userId = userId;
        this.sound = sound;
        this.image = image;
    }

    /*    public MessagePayload(String text, String date, Long userId) {
        this.text = text;
        this.date = date;
        this.userId = userId;
    }*/

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

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
