package codility.lesson03;

/**
 * An array A consisting of N different integers is given. The array contains
 * integers in the range [1..(N + 1)], which means that exactly one element is
 * missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; the elements of A are all
 * distinct; each element of array A is an integer within the range [1..(N +
 * 1)].
 */
public class PermMissingElem {

    /*
     * For N, SUM = (N * (N + 1)) / 2.
     * 
     * By problem definition, array has range [1..N+1].
     * 
     * That is, SUM should be from 1 to A.length + 1.
     * 
     * For SUM, should use long since max int is 2147483647 (~10^9) and
     * N=100000=10^5 and N*N=~10^10
     */
    public int solution(int[] A) {
        long highest = A.length + 1;
        long sum = (highest * (highest + 1)) / 2;
        for (int e : A) {
            sum -= e;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(4 == new PermMissingElem().solution(new int[] { 2, 3, 1, 5 }));
        System.out.println(1 == new PermMissingElem().solution(new int[] { 2 }));
        System.out.println(2 == new PermMissingElem().solution(new int[] { 1 }));
        System.out.println(1 == new PermMissingElem().solution(new int[] {}));
    }

}
