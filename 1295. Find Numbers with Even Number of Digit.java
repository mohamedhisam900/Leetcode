class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            // Check ranges for 2-digit, 4-digit, or 6-digit numbers
            if ((num >= 10 && num <= 99) || 
                (num >= 1000 && num <= 9999) || 
                (num == 100000)) {
                count++;
            }
        }

        return count;
    }
}
