package server.unity.chat.Payload;

public class UserPayload {

    private String login;
    private String nickname;
    private String password;

    public UserPayload(String login, String nickname, String password) {
        this.login = login;
        this.nickname = nickname;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
