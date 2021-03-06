package codility.lesson02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A non-empty array A consisting of N integers is given. The array contains an
 * odd number of elements, and each element of the array can be paired with
 * another element that has the same value, except for one element that is left
 * unpaired.
 * 
 * For example, in array A such that:
 *
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9
 * 
 * the elements at indexes 0 and 2 have value 9, the elements at indexes 1 and 3
 * have value 3, the elements at indexes 4 and 6 have value 9, the element at
 * index 5 has value 7 and is unpaired.
 * 
 * Write a function: class Solution { public int solution(int[] A); }\
 * 
 * that, given an array A consisting of N integers fulfilling the above
 * conditions, returns the value of the unpaired element.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int e : A) {
            if (set.contains(e)) {
                set.remove(e);
            } else {
                set.add(e);
            }
        }
        return set.iterator().next();
    }

    /**
     * Solution using XOR. No need for extra space.
     */
    public int solution2(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(7 == new OddOccurrencesInArray().solution2(new int[] { 9, 3, 9, 3, 9, 7, 9 }));
        System.out.println(9 == new OddOccurrencesInArray().solution2(new int[] { 9 }));
    }
}
