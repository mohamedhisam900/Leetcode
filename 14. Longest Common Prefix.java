class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""
        
        # Take the first string as a baseline
        for i in range(len(strs[0])):
            char = strs[0][i]
            # Compare char with the same index in all other strings
            for string in strs[1:]:
                if i == len(string) or string[i] != char:
                    return strs[0][:i]
                    
        return strs[0]
