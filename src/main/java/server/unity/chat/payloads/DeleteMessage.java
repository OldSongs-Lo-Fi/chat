package server.unity.chat.payloads;

public class DeleteMessage {

    private String message = "Deleting was successfully ended!";

    private boolean success;

    public DeleteMessage(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
