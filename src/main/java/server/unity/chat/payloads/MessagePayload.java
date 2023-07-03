package server.unity.chat.payloads;

import java.util.List;

public class MessagePayload {
    private String text;
    private String date;
    private Long userId;
    private List<String> sound;
    private List<String> image;
    private List<String> files;

    public MessagePayload(String text, String date, Long userId, List<String> sound, List<String> image, List<String> files) {
        this.text = text;
        this.date = date;
        this.userId = userId;
        this.sound = sound;
        this.image = image;
        this.files = files;
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

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public List<String> getSound() {
        return sound;
    }

    public void setSound(List<String> sound) {
        this.sound = sound;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
