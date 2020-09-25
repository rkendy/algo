package codility.lesson04;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 * 
 * A permutation is a sequence containing each element from 1 to N once, and
 * only once.
 * 
 * For example, array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 is a permutation, but array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 is not a permutation, because value 2 is missing.
 * 
 * The goal is to check whether array A is a permutation.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is
 * not.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 the function should return 1.
 * 
 * Given array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 the function should return 0.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [1..1,000,000,000].
 */
public class PermCheck {

    public int solution(int[] A) {
        int[] tmp = new int[A.length];
        for (int e : A) {
            if (e <= A.length) {
                tmp[e - 1] = 1;
            }
        }
        for (int e : tmp) {
            if (e == 0)
                return 0;
        }
        return 1;
    }

    // No extra space, but complexity is n*log(n) due to sort.
    public int solution2(int[] A) {
        Arrays.sort(A);
        int curr = 1;
        for (int e : A) {
            if (e > 0) {
                if (e != curr)
                    return 0;
                curr++;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(1 == new PermCheck().solution(new int[] { 4, 1, 3, 2 }));
        System.out.println(0 == new PermCheck().solution(new int[] { 4, 1, 3 }));
        System.out.println(0 == new PermCheck().solution(new int[] { 4, 1, 3, 1, 1, 4, 3 }));
    }

}
