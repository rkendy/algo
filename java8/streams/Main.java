package java8.streams;

import java.util.List;
import java.util.stream.Collectors;

// https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/
public class Main {

    // Convert elements of a collection to upper case
    public List<String> toUpperCase(List<String> input) {
        return input.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
        // return input.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    // Filter collection so that only elements with less than 4 characters are
    // returned.
    public List<String> filterElements(List<String> collection) {
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
        // return collection.stream().reduce(0, (a, b) -> a + b).intValue();
        return collection.stream().reduce(0, Integer::sum).intValue();
    }

}