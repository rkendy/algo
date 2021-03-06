package codility.lesson07;

import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if
 * any of the following conditions is true:
 * 
 * S is empty; S has the form "(U)" or "[U]" or "{U}" where U is a properly
 * nested string; S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if S is properly
 * nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S =
 * "([)()]", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..200,000]; string S consists only of the
 * following characters: "(", "{", "[", "]", "}" and/or ")".
 */
public class Brackets {
    public int solution(String S) {
        if (S == null)
            return 1;
        if (S.length() % 2 == 1)
            return 0;

        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty())
                    return 0;
                switch (stack.pop()) {
                    case '(':
                        if (c != ')')
                            return 0;
                        break;
                    case '{':
                        if (c != '}')
                            return 0;
                        break;
                    case '[':
                        if (c != ']')
                            return 0;
                }
            }
        }
        return stack.empty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(1 == new Brackets().solution("{[()()]}"));
        System.out.println(0 == new Brackets().solution("([)()]"));
        System.out.println(0 == new Brackets().solution("([()]"));
    }
}
