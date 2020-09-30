package codility.lesson05;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P,
 * Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the
 * slice contains at least two elements). The average of a slice (P, Q) is the
 * sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be
 * precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * 
 * For example, array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the
 * following example slices:
 * 
 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average
 * is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is
 * minimal.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the
 * starting position of the slice with the minimal average. If there is more
 * than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 the function
 * should return 1, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [2..100,000]; each element of array A is an
 * integer within the range [−10,000..10,000].
 */
public class MinAvgTwoSlice {

    public int solution(int[] A) {
        double avg;
        double min = (A[0] + A[1]) / 2.0;
        int start = 0;
        for (int i = 1; i < A.length - 1; i++) {
            avg = (A[i] + A[i + 1]) / 2.0;
            if (avg < min) {
                min = avg;
                start = i;
            }
        }

        for (int i = 0; i < A.length - 2; i++) {
            avg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
            if (avg < min) {
                min = avg;
                start = i;
            }
        }
        return start;
    }

    /**
     * No use of type double.
     */
    public int solution2(int[] A) {
        int indexOfTwo = 0;
        long minSumOfTwo = A[0] + A[1];
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] + A[i + 1] < minSumOfTwo) {
                minSumOfTwo = A[i] + A[i + 1];
                indexOfTwo = i;
            }
        }

        if (A.length > 2) {
            long minSumOfThree = A[0] + A[1] + A[2];
            int indexOfThree = 0;
            for (int i = 1; i < A.length - 2; i++) {
                if (A[i] + A[i + 1] + A[i + 2] < minSumOfThree) {
                    minSumOfThree = A[i] + A[i + 1] + A[i + 2];
                    indexOfThree = i;
                }
            }
            if (2 * minSumOfThree < 3 * minSumOfTwo) {
                return indexOfThree;
            }
        }

        return indexOfTwo;
    }

    public static void main(String[] args) {
        System.out.println(1 == new MinAvgTwoSlice().solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
    }
}
