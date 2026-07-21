from collections import Counter

class Solution:
    def totalNumbers(self, digits: list[int]) -> int:
        freq = Counter(digits)
        count = 0
        
        # Iterate through all possible 3-digit even numbers
        for num in range(100, 1000, 2):
            num_freq = Counter(map(int, str(num)))
            
            # Check if we have enough of each digit available
            if all(freq[d] >= c for d, c in num_freq.items()):
                count += 1
                
        return count
