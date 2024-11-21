package task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// Тестирование ArrayList и LinkedList
public class ListPerformanceComparison {
    private static final List<Integer> arrayList = new ArrayList<>();
    private static final List<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        // Сравнение добавления элементов
        comparePerformance("Add elements at end", 100_000, "addAtEnd");

        // Сравнение вставки элементов в середину
        comparePerformance("Insert elements in the middle", 10_000, "insertInMiddle");

        // Сравнение случайного доступа
        comparePerformance("Random access by index", 10_000, "randomAccess");

        // Сравнение удаления элементов
        comparePerformance("Remove elements from the middle", 10_000, "removeFromMiddle");

        // Сравнение добавления в начало
        comparePerformance("Add elements at beginning", 10_000, "addAtBeginning");

        // Сравнение удаления из начала
        comparePerformance("Remove elements from the beginning", 10_000, "removeFromBeginning");
    }

    private static void comparePerformance(String testName, int operations, String testType) {
        System.out.println("=== " + testName + " ===");

        // ArrayList
        long start = System.nanoTime();
        runTest(arrayList, operations, testType);
        long arrayListTime = System.nanoTime() - start;
        System.out.println("ArrayList: " + arrayListTime / 1_000_000.0 + " ms");

        // LinkedList
        start = System.nanoTime();
        runTest(linkedList, operations, testType);
        long linkedListTime = System.nanoTime() - start;
        System.out.println("LinkedList: " + linkedListTime / 1_000_000.0 + " ms");

        System.out.println();
    }

    private static void runTest(List<Integer> list, int operations, String testType) {
        switch (testType) {
            case "addAtEnd":
                testAddAtEnd(list, operations);
                break;
            case "insertInMiddle":
                testInsertInMiddle(list, operations);
                break;
            case "randomAccess":
                testRandomAccess(list, operations);
                break;
            case "removeFromMiddle":
                testRemoveFromMiddle(list, operations);
                break;
            case "addAtBeginning":
                testAddAtBeginning(list, operations);
                break;
            case "removeFromBeginning":
                testRemoveFromBeginning(list, operations);
                break;
            default:
                throw new IllegalArgumentException("Unknown test type: " + testType);
        }
    }

    private static void testAddAtEnd(List<Integer> list, int operations) {
        for (int i = 0; i < operations; i++) {
            list.add(i);
        }
    }

    private static void testInsertInMiddle(List<Integer> list, int operations) {
        for (int i = 0; i < operations; i++) {
            list.add(list.size() / 2, i);
        }
    }

    private static void testRandomAccess(List<Integer> list, int operations) {
        Random random = new Random();
        for (int i = 0; i < operations; i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }
    }

    private static void testRemoveFromMiddle(List<Integer> list, int operations) {
        for (int i = 0; i < operations; i++) {
            list.remove(list.size() / 2);
        }
    }

    private static void testAddAtBeginning(List<Integer> list, int operations) {
        for (int i = 0; i < operations; i++) {
            list.add(0, i);
        }
    }

    private static void testRemoveFromBeginning(List<Integer> list, int operations) {
        for (int i = 0; i < operations; i++) {
            list.remove(0);
        }
    }
}
