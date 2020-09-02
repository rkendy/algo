package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {

    public static void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");
        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> result = new Main().toUpperCase(collection);

        System.out.println("transformShouldConvertCollectionElementsToUpperCase: " + expected.equals(result));
    }

    static public void transformShouldFilterCollection() {
        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> expected = Arrays.asList("My", "is", "Doe");

        List<String> result = new Main().filterElements(collection);
        System.out.println("transformShouldFilterCollection: " + result.equals(expected));
    }

    static public void transformShouldFlattenCollection() {
        List<List<String>> collection = Arrays.asList( //
                Arrays.asList("Viktor", "Farcic"), //
                Arrays.asList("John", "Doe", "Third"));
        List<String> expected = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");
        List<String> result = new Main().flatMap(collection);
        System.out.println("transformShouldFlattenCollection: " + result.equals(expected));
    }

    static public void getHighestShouldReturnHighest() {
        List<Integer> collection = Arrays.asList(5, 2, 5, 1, 9, 101, 2, 5, 6);
        Integer expected = 101;
        Integer result = new Main().getHighest(collection);
        System.out.println("getHighestShouldReturnHighest: " + result.equals(expected));
    }

    static public void getSumShouldReturnSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer expected = 1 + 2 + 3 + 4 + 5;
        Integer result = new Main().getSum(numbers);
        System.out.println("getSumShouldReturnSum: " + result.equals(expected));
    }

    static private List<Person> createList() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Elanna", 5);
        return Arrays.asList(sara, eva, viktor, anna);
    }

    static public void getNameUnderAgeShouldReturnNamesOfAllKids() {
        List<Person> collection = createList();
        List<String> expected = Arrays.asList("Sara", "Elanna");
        List<String> result = new Main().getNamesUnderAge(collection);
        System.out.println("getNameUnderAgeShouldReturnNamesOfAllKids: " + result.equals(expected));
    }

    static public void getAverageShouldReturnAverage() {
        List<Person> collection = createList();
        Double result = new Main().getAverageAge(collection);
        Double expected = 22.75;
        System.out.println("getAverageShouldReturnAverage: " + expected.equals(result));
    }

    static public void getSumAge() {
        List<Person> collection = createList();
        Integer result = new Main().getSumAge(collection);
        Integer expected = 91;
        System.out.println("getSumAge: " + expected.equals(result));
    }

    static public void partitionAdultsShouldSeparateKidsFromAdults() {
        List<Person> collection = createList();
        Map<Boolean, List<Person>> result = new Main().partitionAdults(collection);
        System.out.print("partitionAdultsShouldSeparateKidsFromAdults: " + (result.get(true).size() == 2));
        System.out.println("\t" + Arrays.toString(result.get(true).toArray()));
        System.out.print("partitionAdultsShouldSeparateKidsFromAdults: " + (result.get(false).size() == 2));
        System.out.println("\t" + Arrays.toString(result.get(false).toArray()));
    }

    static public void partitionByFirstLetterShouldSeparateByFirstLetterName() {
        List<Person> collection = createList();
        Map<Character, List<Person>> result = new Main().partitionByFirstLetter(collection);
        System.out.println("partitionByFirstLetterShouldSeparateByFirstLetterName: " + result);
    }

    static public void getNamesSeparatedByCommaShouldSeparate() {
        List<Person> collection = createList();
        String result = new Main().getNamesSeparatedByComma(collection);
        System.out.println(result);
    }

    static public void getOldestPerson() {
        List<Person> collection = createList();
        Person result = new Main().getOldestPerson(collection);
        System.out.println(result.getAge() == 42);
    }

    public static void main(String[] args) {
        transformShouldConvertCollectionElementsToUpperCase();
        transformShouldFilterCollection();
        transformShouldFlattenCollection();
        getHighestShouldReturnHighest();
        getSumShouldReturnSum();
        getNameUnderAgeShouldReturnNamesOfAllKids();
        getAverageShouldReturnAverage();
        getSumAge();
        partitionAdultsShouldSeparateKidsFromAdults();
        partitionByFirstLetterShouldSeparateByFirstLetterName();
        getNamesSeparatedByCommaShouldSeparate();
        getOldestPerson();
    }
}