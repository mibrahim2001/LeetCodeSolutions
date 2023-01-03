# Intuition

The goal of this function is to count the number of columns in an array of strings that need to be deleted in order to make the array of strings sorted lexicographically(the order in which words are arranged in a dictionary).

# Approach

To achieve this, the function iterates over the columns of the input array of strings, comparing the characters in each column. If it finds any characters that are not in lexicographic order, it increments a counter and moves on to the next column. If it makes it through all the columns without finding any characters that are not in lexicographic order, it returns the final value of the counter.

# Complexity

- Time complexity:
  O(N \* M), where N is the number of strings in the input array and M is the length of the each string in the input array because in this problem all the strings were of equal length. This is because the function must iterate over every character in every string in the input array.

- Space complexity:
  O(1), since the function only uses a constant amount of space regardless of the size of the input.

# Code

```
class Solution {
    public int minDeletionSize(String[] strs) {
    int deletions = 0;

    // Iterate over the columns of the input array of strings
    for (int i = 0; i < strs[0].length(); i++) {
        /* Take the ith character of the string(ith
        column of the first row)*/
        char prev = strs[0].charAt(i);

        // Iterate over the remaining strings in the input array
        for (int j = 1; j < strs.length; j++) {
            char current = strs[j].charAt(i);
            if (prev > current) {
                deletions++;
                break;
            } else {
                prev = current;
            }
        }
    }
    return deletions;
    }
}

```
