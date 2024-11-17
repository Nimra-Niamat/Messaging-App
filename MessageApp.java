import java.io.IOException;
import java.util.Scanner;

public class MessageApp {
    private static Contactmanager contactManager = new Contactmanager();
    private static MessageManager messageManager = new MessageManager();
    private static Scanner sc = new Scanner(System.in);
    private static Receiver receiver;

    public static void main(String[] args) {
        
        startReceiver();

        while (true) {
            System.out.println("\n====== Message App Menu ======\n");
            System.out.println("1. Add Contact");
            System.out.println("2. Show Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Send Message");
            System.out.println("7. View Messages");
            System.out.println("8. Edit Message");
            System.out.println("9. Delete Message");
            System.out.println("10. Delete All Messages");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: \n");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    contactManager.addContact();
                    break;
                case 2:
                    contactManager.showContactList();
                    break;
                case 3:
                    contactManager.searchContact();
                    break;
                case 4:
                    contactManager.editContact();
                    break;
                case 5:
                    contactManager.deleteContact();
                    break;
                case 6:
                    sendMessage();
                    break;
                case 7:
                    viewMessages();
                    break;
                case 8:
                    messageManager.editMessage(getContactFromUser());
                    break;
                case 9:
                    messageManager.deleteMessage(getContactFromUser());
                    break;
                case 10:
                    messageManager.deleteAllMessages();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    private static void startReceiver() {
        new Thread(() -> {
            try {
                receiver = new Receiver(12345);  
                receiver.listenForMessages();  
            } catch (IOException e) {
                System.out.println("Error starting receiver: " + e.getMessage());
            }
        }).start();
    }

    private static void sendMessage() {
        Contact sender = getContactFromUser();
        Contact receiver = getReceiverContact();
        try {
            Sender senderClient = new Sender("localhost", 12345); 
            senderClient.sendMessage("Hello, this is a test message!");
            senderClient.close();
        } catch (IOException e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
    }

    private static void viewMessages() {
        Contact contact = getContactFromUser();
        messageManager.displayMessages(contact);
    }

    private static Contact getContactFromUser() {
        System.out.print("Enter Sender Name: ");
        String name = sc.nextLine();
        return contactManager.getContactByName(name);
    }

    private static Contact getReceiverContact() {
        System.out.print("Enter receiver contact name: ");
        String name = sc.nextLine();
        return contactManager.getContactByName(name);
    }
}
