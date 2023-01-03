# Intuition

To solve the problem of determining whether the usage of capital letters in a word is correct, you can use a regular expression to match the word against a set of patterns that represent the three conditions described in the problem statement:

All letters in the word are capitals, like "USA".
All letters in the word are not capitals, like "leetcode".
Only the first letter in the word is capital, like "Google".

# Approach

To match these conditions with a regular expression, you can use the following steps:

Define a regular expression that consists of three alternative patterns separated by | characters.
Enclose each pattern in parentheses.
Anchor the regular expression to the start and end of the string with the ^ and $ characters.
The first pattern should match any string that consists of one or more capital letters. You can use the character class [A-Z] to match a capital letter, and the + quantifier to match one or more of these letters.

The second pattern should match any string that consists of one or more lowercase letters. You can use the character class [a-z] to match a lowercase letter, and the + quantifier to match one or more of these letters.

The third pattern should match any string that starts with a capital letter and has one lowercase letter after it. You can use the character class [A-Z] to match a capital letter, and the character class [a-z] to match a lowercase letter. You can use the _ quantifier to match zero or more of these letters, but since the condition specifies that there should be exactly one lowercase letter, you should not use the _ quantifier in this case.

# Complexity

- Time complexity:
  The time complexity of using a regular expression to match a string is typically O(n), where n is the length of the string being matched.

- Space complexity:
  The space complexity of using a regular expression to match a string is typically O(1)

# Code

```
class Solution {
    public boolean detectCapitalUse(String word) {
        return (word.matches("^([A-Z]+|[a-z]+|[A-Z][a-z]*)$"));
    }
}
```
