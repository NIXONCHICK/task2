package task2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape", "pear", "apple", "grape", "kiwi", "pear", "kiwi", "melon", "apple", "melon");
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println("Уникальные слова: " + uniqueWords);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество повторений слов: " + wordCount);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Smith", "123-456-789");
        phoneBook.add("Smith", "987-654-321");
        phoneBook.add("Johnson", "555-555-555");
        phoneBook.add("Williams", "333-222-111");

        System.out.println("Номера телефонов Smith: " + phoneBook.get("Smith"));
        System.out.println("Номера телефонов Johnson: " + phoneBook.get("Johnson"));
        System.out.println("Номера телефонов Williams: " + phoneBook.get("Williams"));
        System.out.println("Номера телефонов Brown: " + phoneBook.get("Brown"));
    }
}

class PhoneBook {
    private final Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        this.phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return this.phoneBook.getOrDefault(surname, Collections.emptyList());
    }
}
