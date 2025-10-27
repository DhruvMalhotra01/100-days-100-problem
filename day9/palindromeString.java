public class palindromeString {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // odd
            int len2 = expandFromCenter(s, i, i + 1);   // even
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;  // length of palindrome
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // Output: bab or aba
        System.out.println(longestPalindrome("cbbccd"));  // Output: bb
    }
}
