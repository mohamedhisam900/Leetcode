import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] charFreq = new int[26];
            for (char c : word.toCharArray()) {
                charFreq[c - 'a']++;
            }
            
            // Keep the minimum frequency of each character across all words
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }

        // Build the result list based on minFreq array
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;
    }
}
