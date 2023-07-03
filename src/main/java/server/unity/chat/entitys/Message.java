package server.unity.chat.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "message_table")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String text;

    @Column(nullable = false,
            columnDefinition = "VARCHAR (40)")
    private String date;

    @Lob
    @Column(columnDefinition = "BLOB")
    private List<String> sound;

    @Lob
    @Column(columnDefinition = "BLOB")
    private List<String> image;

    @Lob
    @Column(columnDefinition = "BLOB")
    private List<String> files;

    public Message(User user, String text, String date, List<String> sound, List<String> image, List<String> files) {
        this.user = user;
        this.text = text;
        this.date = date;
        this.sound = sound;
        this.image = image;
        this.files = files;
    }

    /*    public Message(User user, String text, String date) {
        this.user = user;
        this.text = text;
        this.date = date;
    }*/

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
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