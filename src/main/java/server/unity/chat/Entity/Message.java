package server.unity.chat.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class,
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
/*
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
*/
    private User user;

/*    @Column(nullable = false,
            columnDefinition = "TEXT")*/
    private String text;


/*    @Column(nullable = false,
            updatable = false,
            columnDefinition = "VARCHAR 20")*/
    private String date;

    public Message(User user, String text, String date) {
        this.user = user;
        this.text = text;
        this.date = date;
    }

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

}
