import java.util.ArrayList;
import java.util.Scanner;

public class Contactmanager {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addContact() {
        String choice;
        do {    //Exception Handling
            try {
                System.out.println("|_____Add New Contact______|");

                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be empty. Please enter a valid name.");
                }

                String contactNumber;
                while (true) {
                    System.out.print("Enter Contact Number (Format: 03XX-XXXXXXX): ");
                    contactNumber = sc.nextLine();
                    if (contactNumber.matches("03\\d{2}-\\d{7}")) {
                        break;
                    } else {
                        System.out.println("Invalid format! Please enter the number in the format: 03XX-XXXXXXX");
                    }
                }

                Contact contact = new Contact(name, contactNumber);
                contacts.add(contact);
                System.out.println("Contact successfully added!");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

           
            System.out.print("Do you want to add another contact? (yes/no): ");
            choice = sc.nextLine().trim().toLowerCase();

        } while (choice.equals("yes"));

        System.out.println("Contact addition completed.");
    }

    public void showContactList() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchContact() {
        System.out.println("____Find Contact____");
        System.out.print("Enter Contact Name: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found: " + contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void editContact() {
        System.out.println("_____Edit Contact____");
        System.out.print("Enter Contact Name to edit: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();
                System.out.print("Enter New Contact Number: ");
                String newContactId = sc.nextLine();
                contact.setName(newName);
                contact.setContactId(newContactId);
                found = true;
                System.out.println("Contact updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public Contact getContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        System.out.println("Contact not found.");
        return null;
    }
    public void deleteContact() {
        System.out.println("_____Delete Contact_____");
        System.out.print("Enter Contact Name to delete: ");
        String name = sc.nextLine();
        boolean found = false;

       
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                found = true;
                System.out.println("Contact '" + name + "' has been deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}
