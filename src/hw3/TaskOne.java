package hw3;

import java.util.*;

public class TaskOne {
    // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    // Посчитать, сколько раз встречается каждое слово.

    public static void main(String[] args) {

    String [] cities = new String[]{"Москва", "Винница", "Донецк", "Ярославль","Смоленск","Москва", "Краснодар", "Киев", "Сумы",
    "Чернигов", "Смоленск", "Львов", "Москва", "Кострома", "Краснодар", "Иваново", "Чернигов" };

        HashMap <String, Integer> countCities = new HashMap<>();
        for (String city : cities) {
            if (!countCities.containsKey(city)) {
                countCities.put(city,1);
            } else {
                countCities.put(city, countCities.get(city) + 1);
            }
        }
        System.out.println(countCities);
    }
}
