package server.unity.chat.facades;

public class MessageFacade {
    private String nickname;
    private String text;
    private String date;
    private String sound;
    private String image;

    public MessageFacade(String nickname, String text, String date, String sound, String image) {
        this.nickname = nickname;
        this.text = text;
        this.date = date;
        this.sound = sound;
        this.image = image;
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
