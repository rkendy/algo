package codility.lesson01;

import java.util.Arrays;

public class BinaryGap {
    /**
     * A binary gap within a positive integer N is any maximal sequence of consecutive zeros 
     * that is surrounded by ones at both ends in the binary representation of N.
     * 
     * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. 
     * The number 529 has binary representation 1000010001 and contains two binary gaps: one of 
     * length 4 and one of length 3. The number 20 has binary representation 10100 and contains one 
     * binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. 
     * The number 32 has binary representation 100000 and has no binary gaps.
     * 
     * Write a function that, given a positive integer N, returns the length of its longest binary gap. 
     * The function should return 0 if N doesn't contain a binary gap.
     * 
     * Write an efficient algorithm for the following assumptions:
     * N is an integer within the range [1..2,147,483,647].
     */


    public int solution(int N) {
        String str = Integer.toBinaryString(N);
        boolean started = false;
        int count = 0;
        int max = 0;
        for(char c : str.toCharArray()) {
            if(started) {
                if(c == '0') count++;
                else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            else {
                if(c == '1') {
                    started = true;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().solution(9) == 2);
        System.out.println(new BinaryGap().solution(529) == 4);
        System.out.println(new BinaryGap().solution(20) == 1);
        System.out.println(new BinaryGap().solution(15) == 0);
        System.out.println(new BinaryGap().solution(32) == 0);
        System.out.println(new BinaryGap().solution(1041) == 5);

    }
}
