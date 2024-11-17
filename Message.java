import java.time.LocalDateTime;

public class Message {
    private final String sender;
    private final String receiver;
    private final String content;
    private LocalDateTime timestamp;
    private Status status;
    private String messageID;

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.status = Status.SENT;  
        this.messageID = sender + timestamp.toString();
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTime() {
        return timestamp;
    }

    public String getMessageID() {
        return messageID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("From: " + sender + " To: " + receiver);
        System.out.println("Message: " + content + " (" + status + ")");
        System.out.println("Time: " + timestamp);
    }
}
