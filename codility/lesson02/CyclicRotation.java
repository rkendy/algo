package codility.lesson02;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means 
 * that each element is shifted right by one index, and the last element of 
 * the array is moved to the first place. For example, the rotation of array 
 * A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one 
 * index and 6 is moved to the first place).
 * 
 * The goal is to rotate array A K times; that is, each element of A will be 
 * shifted to the right K times.
 * 
 * Write a function: class Solution { public int[] solution(int[] A, int K); }
 * that, given an array A consisting of N integers and an integer K, returns 
 * the array A rotated K times.
 */
public class CyclicRotation {
   
    public int[] solution(int[] A, int K) {
        int size = A.length;        
        int[] result = new int[size];
        int shift = size > 0 ? K % size : 0;
        for(int i=0 ; i<size; i++) {
            result[(i+shift) % size] = A[i];
        }
        return result;
    }

    public int[] solution2(int[] A, int K) {

        int size = A.length;
        if(size == 0) return A;

        int shift = size > 0 ? K % size : 0;

        int curr = 0;
        int prevValue = A[curr];
        
        for(int i=0 ; i<size ; i++) {
            int newIndex = (curr + shift) % size;
            int tmp = A[newIndex];
            A[newIndex] = prevValue;
            
            curr = newIndex;
            prevValue = tmp;
        }

        return A;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[] {9,7,6,3,8}, new int[] {3,8,9,7,6}, 3));
        System.out.println(check(new int[] {0,0,0}, new int[] {0,0,0}, 1));
        System.out.println(check(new int[] {1,2,3,4}, new int[] {1,2,3,4}, 4));
        System.out.println(check(new int[] {}, new int[] {}, 4));
    }

    public static boolean check(int[] expected, int[] input, int K) {
        return Arrays.equals(expected, new CyclicRotation().solution2(input,K));
    }
}
