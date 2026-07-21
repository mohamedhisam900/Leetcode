class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        # Check if all uppercase, all lowercase, or title case (e.g., "Google")
        return word.isupper() or word.islower() or word.istitle()
        
