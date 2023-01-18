package practice;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("79138205145", "Алексей");
        phoneBook.getAllContacts().forEach(System.out::println);
        System.out.println(phoneBook.getContactByPhone("79138205145"));
        System.out.println(phoneBook.getContactByName("Алексей"));

    }
}
