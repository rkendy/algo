package java8.streams;

import java.util.List;
import java.util.stream.Collectors;

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

}