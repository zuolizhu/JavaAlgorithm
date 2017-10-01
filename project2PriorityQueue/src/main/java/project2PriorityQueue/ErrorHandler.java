package project2PriorityQueue;

import java.io.Serializable;

public class ErrorHandler implements Serializable {

    private String message;

    public ErrorHandler() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
