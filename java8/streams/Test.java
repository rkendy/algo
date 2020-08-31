package java8.streams;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");
        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> result = new Main().toUpperCase(collection);

        System.out.println(expected.equals(result));
    }

    static public void transformShouldFilterCollection() {
        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> expected = Arrays.asList("My", "is", "Doe");

        List<String> result = new Main().filterElements(collection);
        System.out.println(result.equals(expected));
    }

    static public void transformShouldFlattenCollection() {
        List<List<String>> collection = Arrays.asList( //
                Arrays.asList("Viktor", "Farcic"), //
                Arrays.asList("John", "Doe", "Third"));
        List<String> expected = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");
        List<String> result = new Main().flatMap(collection);
        System.out.println(result.equals(expected));
    }

    static public void getHighestShouldReturnHighest() {
        List<Integer> collection = Arrays.asList(5, 2, 5, 1, 9, 101, 2, 5, 6);
        Integer expected = 101;
        Integer result = new Main().getHighest(collection);
        System.out.println(result.equals(expected));
    }

    static public void getSumShouldReturnSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer expected = 1 + 2 + 3 + 4 + 5;
        Integer result = new Main().getSum(numbers);
        System.out.println(result.equals(expected));
    }

    public static void main(String[] args) {
        transformShouldConvertCollectionElementsToUpperCase();
        transformShouldFilterCollection();
        transformShouldFlattenCollection();
        getHighestShouldReturnHighest();
        getSumShouldReturnSum();
    }
}