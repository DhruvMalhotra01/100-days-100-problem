import java.util.*;
class xorString {
    public char findTheDifference(String s, String t) {
        int result1 = 0; 
        int result2 = 0;
        for (char ch : s.toCharArray()) result1 ^= ch;
        for (char ch : t.toCharArray()) result2 ^= ch;
        // int result = s ^ t;
        int result = result1 ^ result2;
        return (char) result; 
    }
    public static void main(String[] args) {
        xorString solution = new xorString();
        String s = "abcd";
        String t = "abcde";
        char extraChar = solution.findTheDifference(s, t);
        System.out.println("The extra character is: " + extraChar); // Output: e
    }
}
