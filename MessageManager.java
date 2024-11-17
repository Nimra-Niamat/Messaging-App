import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MessageManager {
    private ArrayList<Message> messages = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void sendMessage(Contact sender, Contact receiver) {
        System.out.println("Enter your message:");
        String content = sc.nextLine();
        Message message = new Message(sender.getContactId(), receiver.getContactId(), content);
        messages.add(message);
        System.out.println("Message sent from " + sender.getName() + " to " + receiver.getName());
    }

    public void displayMessages(Contact contact) {
        System.out.println("Messages for " + contact.getName());
        boolean hasMessages = false;
        for (Message message : messages) {
            if (message.getReceiver().equals(contact.getContactId()) || message.getSender().equals(contact.getContactId())) {
                message.displayDetails();
                hasMessages = true;
            }
        }
        if (!hasMessages) {
            System.out.println("No messages found for " + contact.getName());
        }
    }

   
    public void deleteMessage(Contact contact) {
        System.out.println("Enter Message ID to delete:");
        String messageId = sc.nextLine();
        Iterator<Message> iterator = messages.iterator();
        while (iterator.hasNext()) {
            Message message = iterator.next();
            if (message.getMessageID().equals(messageId)) {
                iterator.remove();
                System.out.println("Message deleted.");
                return;
            }
        }
        System.out.println("Message not found.");
    }

  
    public void deleteAllMessages() {
        messages.clear();
        System.out.println("All messages deleted.");
    }

    
    public void editMessage(Contact contact) {
        System.out.println("Enter Message ID to edit:");
        String messageId = sc.nextLine();
        for (Message message : messages) {
            if (message.getMessageID().equals(messageId)) {
                if (message.getTime().isAfter(java.time.LocalDateTime.now().minusMinutes(5))) { 
                    System.out.println("Enter new message content:");
                    String newContent = sc.nextLine();
                    message.setStatus(Status.SENT);  
                    System.out.println("Message updated.");
                    return;
                } else {
                    System.out.println("Time limit exceeded for editing this message.");
                    return;
                }
            }
        }
        System.out.println("Message not found.");
    }
}
