package java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/
public class Main {

    // Convert elements of a collection to upper case
    List<String> toUpperCase(List<String> input) {
        return input.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
        // return input.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    // Filter collection so that only elements with less than 4 characters are
    // returned.
    List<String> filterElements(List<String> collection) {
        return collection.stream().filter(e -> e.length() < 4).collect(Collectors.toList());
    }

    // Flatten multidimensional collection
    List<String> flatMap(List<List<String>> input) {
        return input.stream().flatMap(lst -> lst.stream()).collect(Collectors.toList());
    }

    // Get highest from the collection
    Integer getHighest(List<Integer> collection) {
        return collection.stream().max(Integer::compareTo).get();
        // return collection.stream().mapToInt(v -> v).max().getAsInt();
    }

    // Sum all elements of a collection
    Integer getSum(List<Integer> collection) {
        // return collection.stream().mapToInt(v -> v).sum();
        // return collection.stream().reduce(0, (total, element) -> //
        // total + element).intValue();
        return collection.stream().reduce(0, Integer::sum).intValue();
    }

    // Get names of all under age of 18
    List<String> getNamesUnderAge(List<Person> collection) {
        // return collection.stream() //
        // .filter(e -> e.getAge() < 18) //
        // .map(e -> e.getName()).collect(Collectors.toList());
        return collection.stream().filter(e -> e.getAge() < 18).map(Person::getName).collect(Collectors.toList());
    }

    // Get average age
    Double getAverageAge(List<Person> collection) {
        // return collection.stream().mapToInt(e -> e.getAge()).average().getAsDouble();
        return collection.stream().mapToInt(Person::getAge).average().getAsDouble();
    }

    // Get sum age
    Integer getSumAge(List<Person> collection) {
        return collection.stream().mapToInt(Person::getAge).sum();
    }

    // Partition adults and kids
    Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
        return collection.stream().collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
    }

    // Group people by first letter
    Map<Character, List<Person>> partitionByFirstLetter(List<Person> collection) {
        return collection.stream().collect(Collectors.groupingBy(e -> e.getName().charAt(0)));
    }

    // Return people names separated by comma
    String getNamesSeparatedByComma(List<Person> collection) {
        return collection.stream().map(Person::getName).collect(Collectors.joining(", "));
    }

}