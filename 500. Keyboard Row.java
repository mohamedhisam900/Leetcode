import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map characters to their keyboard row index (1, 2, or 3)
        int[] rows = new int[26];
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        for (char c : row1.toCharArray()) rows[c - 'a'] = 1;
        for (char c : row2.toCharArray()) rows[c - 'a'] = 2;
        for (char c : row3.toCharArray()) rows[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int targetRow = rows[lower.charAt(0) - 'a'];
            boolean isValid = true;

            for (int i = 1; i < lower.length(); i++) {
                if (rows[lower.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
