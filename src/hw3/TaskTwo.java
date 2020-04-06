package hw3;

public class TaskTwo {
    //Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
    // В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
    // искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
    // (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

    public static void main(String[] args) {
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.addPhoneNumber("Иванов", "528735");
            phoneBook.addPhoneNumber("Петров", "435568");
            phoneBook.addPhoneNumber("Васильев", "777777");
            phoneBook.addPhoneNumber("Иванов", "739285");

            System.out.println(phoneBook.get("Иванов"));
            System.out.println(phoneBook.get("Васильев"));
            System.out.println(phoneBook.get("Ильенко"));
        }
    }

