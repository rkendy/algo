package codility.lesson08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A non-empty array A consisting of N integers is given.
 * 
 * The leader of this array is the value that occurs in more than half of the
 * elements of A.
 * 
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0],
 * A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the
 * same value.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 we can find two equi
 * leaders:
 * 
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose
 * value is 4. 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same
 * leader, whose value is 4. The goal is to count the number of equi leaders.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the number
 * of equi leaders.
 * 
 * For example, given:
 * 
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 the function should
 * return 2, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000,000..1,000,000,000].
 */
public class EquiLeader {

    private int countMax = 0;
    Map<Integer, Integer> map;
    Integer leader;

    private Integer update(Integer currentElement, int numberElements) {
        int count = map.getOrDefault(currentElement, 0) + 1;
        map.put(currentElement, count);

        if (count > countMax) {
            countMax = count;
            leader = currentElement;
        }
        if (countMax < ((numberElements / 2) + 1)) {
            return null;
        }
        return leader;
    }

    public int solution(int[] A) {
        int size = A.length;

        // Calculate leaders from left to right:
        Integer[] fromLeftArray = new Integer[size];
        map = new HashMap<>();
        countMax = 0;
        for (int i = 0; i < size; i++) {
            fromLeftArray[i] = update(A[i], i + 1);
        }

        // Calculate leaders from right to left:
        Integer[] fromRightArray = new Integer[size];
        map = new HashMap<>();
        countMax = 0;
        for (int i = size - 1; i >= 0; i--) {
            fromRightArray[i] = update(A[i], size - i);
        }

        // Calculate equi leader that are equal:
        int count = 0;
        for (int i = 0; i < size - 1; i++) {
            if (fromLeftArray[i] != null && fromRightArray[i + 1] != null) {
                if (fromLeftArray[i].equals(fromRightArray[i + 1]))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(2 == new EquiLeader().solution(new int[] { 4, 3, 4, 4, 4, 2 }));
        System.out.println(1 == new EquiLeader().solution(new int[] { 4, 4 }));
        System.out.println(0 == new EquiLeader().solution(new int[] { 4, 3 }));
        System.out.println(0 == new EquiLeader().solution(new int[] { 3, 4 }));
        System.out.println(1 == new EquiLeader().solution(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE }));
    }
}