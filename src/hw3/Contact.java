package hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contact {

        private String surname;

        private List<String> phoneNumbers;

        public Contact(String surname) {
            this.surname = surname;
            this.phoneNumbers = new ArrayList<>();
        }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addPhoneNumber(String number) {
            phoneNumbers.add(number);
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }
    }
