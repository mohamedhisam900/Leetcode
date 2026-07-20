import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 1: Count frequency of each number in nums
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: Count how many numbers are multiples of each i
        long[] countMultiples = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                countMultiples[i] += freq[j];
            }
        }

        // Step 3: Use inclusion-exclusion to get exact gcd counts
        long[] gcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalPairsWithDivisor = countMultiples[i] * (countMultiples[i] - 1) / 2;
            long subtractOvercounts = 0;
            for (int j = 2 * i; j <= maxVal; j += i) {
                subtractOvercounts += gcdCount[j];
            }
            gcdCount[i] = totalPairsWithDivisor - subtractOvercounts;
        }

        // Step 4: Compute prefix sums of the GCD counts
        long[] prefixGcd = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixGcd[i] = prefixGcd[i - 1] + gcdCount[i];
        }

        // Step 5: Answer each query using binary search
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            
            // Binary search for the first GCD index where prefixGcd[mid] > q
            int low = 1, high = maxVal;
            int bestGcd = maxVal;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixGcd[mid] > q) {
                    bestGcd = mid;
                    high = mid - 1; // Try to find a smaller valid GCD
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = bestGcd;
        }

        return ans;
    }
}
