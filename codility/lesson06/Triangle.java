package codility.lesson06;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is
 * triangular if 0 ≤ P < Q < R < N and:
 * 
 * A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q]. For example,
 * consider array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 Triplet (0, 2, 4) is
 * triangular.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns 1 if there exists a
 * triangular triplet for this array and returns 0 otherwise.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 the function should
 * return 1, as explained above. Given array A such that:
 * 
 * A[0] = 10 A[1] = 50 A[2] = 5 A[3] = 1 the function should return 0.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647].
 */
public class Triangle {

    /**
     * Proof:
     * 
     * 1) Ignore elements that are <= 0, since there is no possible solution.
     *
     * Proof of 1)
     * 
     * Assume A + B > C, where C <= 0. Then:
     * 
     * A + C > B => Then: A > B.
     * 
     * B + C > A => Then: B > A.
     * 
     * Contradiction.
     * 
     * Thus, we should ignore negative numbers.
     * 
     * 
     * 2) Assume A<=B<=C, and A > 0 (thus B and C > 0). If A + B > C, then:
     * 
     * B + C > A and A + C > B.
     * 
     * Proof of 2)
     * 
     * Assume by contradiction that B + C <= A. Then A > B and A > C, which is
     * false.
     * 
     * Assume by contradiction that A + C <= B. Then B > C, which is false.
     * 
     * Thus, it is enough to check if A + B > C, considering 0 < A <= B <= C.
     * 
     * 
     */
    public int solution(int[] A) {
        // Ensure that A <= B <= C:
        Arrays.sort(A);

        // 1) Ignore elements <= 0:
        int index = 0;
        while (index < A.length && A[index] <= 0)
            index++;

        // 2) Check if A + B < C:
        while (index < A.length - 2) {
            if ((long) A[index] + A[index + 1] > A[index + 2])
                return 1;
            index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1 == new Triangle().solution(new int[] { 10, 2, 5, 1, 8, 20 }));
        System.out.println(0 == new Triangle().solution(new int[] { 10, 50, 5, 1 }));
    }
}
