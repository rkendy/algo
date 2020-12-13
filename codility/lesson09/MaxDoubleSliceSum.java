package codility.lesson09;

/**
 * A non-empty array A consisting of N integers is given.
 * 
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * 
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... +
 * A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * 
 * For example, array A such that:
 * 
 * A[0] = 3 A[1] = 2 A[2] = 6 A[3] = -1 A[4] = 4 A[5] = 5 A[6] = -1 A[7] = 2
 * contains the following example double slices:
 * 
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17, double slice (0, 3, 7),
 * sum is 2 + 6 + 4 + 5 − 1 = 16, double slice (3, 4, 5), sum is 0. The goal is
 * to find the maximal sum of any double slice.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the maximal
 * sum of any double slice.
 * 
 * For example, given:
 * 
 * A[0] = 3 A[1] = 2 A[2] = 6 A[3] = -1 A[4] = 4 A[5] = 5 A[6] = -1 A[7] = 2 the
 * function should return 17, because no double slice of array A has a sum of
 * greater than 17.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [3..100,000]; each element of array A is an
 * integer within the range [−10,000..10,000].
 */
public class MaxDoubleSliceSum {

    /**
     * Use two arrays:
     * 
     * maxEndingAt: max ending at given index.
     * 
     * maxStartingAt: max starting at given index.
     * 
     */
    public int solution(int[] A) {
        int size = A.length;
        int[] maxEndingAt = new int[size];
        int[] maxStartingAt = new int[size];

        maxEndingAt[0] = 0;
        for (int i = 1; i < size - 1; i++) {
            maxEndingAt[i] = Math.max(maxEndingAt[i - 1] + A[i], 0);
        }
        maxStartingAt[size - 1] = 0;
        for (int i = size - 2; i > 0; i--) {
            maxStartingAt[i] = Math.max(maxStartingAt[i + 1] + A[i], 0);
        }

        int result = 0;
        for (int i = 1; i < size - 1; i++) {
            result = Math.max(result, maxEndingAt[i - 1] + maxStartingAt[i + 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(17 == new MaxDoubleSliceSum().solution(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
    }
}
