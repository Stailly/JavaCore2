package hw3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, Contact> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addPhoneNumber(String surname, String phoneNumber) {
        Contact contact;
        String key = surname;
        if (phoneBook.containsKey(key)) {
            contact = phoneBook.get(key);
        } else {
            contact = new Contact(surname);
            phoneBook.put(key, contact);
        }
        contact.addPhoneNumber(phoneNumber);
    }

    public List get(String surname) {
        String key = surname;
        if (!phoneBook.containsKey(key)) {
            return Collections.EMPTY_LIST;
        }
        return phoneBook.get(key).getPhoneNumbers();
    }
}
