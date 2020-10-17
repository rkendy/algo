package codility.lesson07;

/**
 * A string S consisting of N characters is called properly nested if:
 * 
 * S is empty; S has the form "(U)" where U is a properly nested string; S has
 * the form "VW" where V and W are properly nested strings. For example, string
 * "(()(())())" is properly nested but string "())" isn't.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if string S is
 * properly nested and 0 otherwise.
 * 
 * For example, given S = "(()(())())", the function should return 1 and given S
 * = "())", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..1,000,000]; string S consists only of
 * the characters "(" and/or ")".
 */
public class Nesting {
    public int solution(String S) {
        int countOpen = 0;
        for (char c : S.toCharArray()) {
            if (c == '(')
                countOpen += 1;
            else {
                if (countOpen == 0)
                    return 0;
                countOpen -= 1;
            }
        }
        return countOpen == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(1 == new Nesting().solution("(()(())())"));
        System.out.println(0 == new Nesting().solution("())"));
    }
}