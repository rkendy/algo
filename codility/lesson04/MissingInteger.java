package codility.lesson04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a demo task.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 */
public class MissingInteger {

    public int solution(int[] A) {
        Arrays.sort(A);
        int min = 1;
        for (int e : A) {
            if (e > 0) {
                if (min < e)
                    return min;
                min = e + 1;
            }
        }
        return min;
    }

    // Sort shorter array when eliminating negative and repeated numbers
    public int solution2(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int e : A) {
            if (e > 0)
                set.add(e);
        }
        Integer[] numbers = set.toArray(new Integer[0]);
        Arrays.sort(numbers);
        int min = 1;
        for (int e : numbers) {
            if (min < e)
                return min;
            min = e + 1;
        }
        return min;
    }

    // Use tmp array with same size as input A.
    // In tmp, set 1 at index i where i + 1 is present in A. Set 0 otherwise.
    // Consider only values from 1 to size.
    // If there is an higher value than size, there must be a missing integer lower
    // than size.
    public int soluction3(int[] A) {
        int size = A.length;
        int[] tmp = new int[size];

        for (int e : A) {
            if (e >= 1 && e <= size) {
                tmp[e - 1] = 1;
            }
        }
        for (int i = 0; i < size; i++) {
            if (tmp[i] == 0)
                return i + 1;
        }
        return size + 1;

    }

    public static void main(String[] args) {
        System.out.println(5 == new MissingInteger().solution(new int[] { 1, 3, 6, 4, 1, 2 }));
        System.out.println(4 == new MissingInteger().solution(new int[] { 1, 2, 3 }));
        System.out.println(1 == new MissingInteger().solution(new int[] { -1, -3 }));
    }
}
