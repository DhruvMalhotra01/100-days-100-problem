import java.util.*;

public class wordBreak {
    public static void main(String[] args) {
        // Example test case
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        Solution sol = new Solution();
        System.out.println(sol.wordBreak(s, wordDict)); // Expected: true
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, wordDict, 0, memo);
    }

    private boolean helper(String s, List<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) return true;

        if (memo[start] != null) return memo[start]; // use cached result

        for (int i = start + 1; i <= s.length(); i++) {
            String prefix = s.substring(start, i);
            if (wordDict.contains(prefix)) {
                if (helper(s, wordDict, i, memo)) {
                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false;
        return false;
    }
}
