class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        # A pangram must contain all 26 unique English alphabet letters
        return len(set(sentence)) == 26
