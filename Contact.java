public class Contact {
    private String name;
    private String contactId;  

    public Contact(String name, String contactId) {
        this.name = name;
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Contact ID: " + contactId;
    }
}
