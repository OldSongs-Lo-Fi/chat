package server.unity.chat.facades;

import java.util.List;

public class MessageFacade {
    private String nickname;
    private String text;
    private String date;
    private List<String> sound;
    private List<String> image;
    private List<String> files;

    public MessageFacade(String nickname, String text, String date, List<String> sound, List<String> image, List<String> files) {
        this.nickname = nickname;
        this.text = text;
        this.date = date;
        this.sound = sound;
        this.image = image;
        this.files = files;
    }

    /*    public MessageFacade(String nickname, String text, String date) {
        this.nickname = nickname;
        this.text = text;
        this.date = date;
    }*/

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

    public List<String> getSound() {
        return sound;
    }

    public void setSound(List<String> sound) {
        this.sound = sound;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
