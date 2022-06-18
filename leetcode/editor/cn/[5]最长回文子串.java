//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5349 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// Method 1: DP
//class Solution {
//    static class Cell {
//        int i;
//        int j;
//        int len;
//        public Cell(int i, int j) {
//            this.i = i;
//            this.j = j;
//            this.len = j - i + 1;
//        }
//    }
//
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() <= 1) {
//            return s;
//        }
//        boolean[][] M = new boolean[s.length()][s.length()];
//        Cell result = new Cell(0, 0);
//        for (int j = 0; j < s.length(); j++) {
//            for (int i = j; i >= 0; i--) {
//                if (i == j) {
//                    M[i][j] = true;
//                    if (j - i + 1 > result.len) {
//                        result = new Cell(i, j);
//                    }
//                } else if (i == j - 1) {
//                    if (s.charAt(i) == s.charAt(j)) {
//                        M[i][j] = true;
//                        if (j - i + 1 > result.len) {
//                            result = new Cell(i, j);
//                        }
//                    }
//                } else {
//                    M[i][j] = M[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
//                    if (M[i][j] && j - i + 1 > result.len) {
//                        result = new Cell(i, j);
//                    }
//                }
//            }
//        }
//        return s.substring(result.i, result.j + 1);
//    }
//}
// Method 2: Expand around center
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
