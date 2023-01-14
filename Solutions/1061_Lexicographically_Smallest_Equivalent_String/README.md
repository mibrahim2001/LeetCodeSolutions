# Intuition

This code is solving the problem of finding the smallest equivalent string of a given base string using two other strings (s1 and s2) as references. It does this by using a union-find algorithm, which is a data structure that keeps track of a partition of a set into disjoint subsets.

# Approach

The approach used here is to first initialize the root array, where each element is in its own group. Then, for each character in s1 and s2, the unite function is called to combine their corresponding elements into a single group. Finally, the final answer is built by looking up the root element (smallest) of each character in the base string.

# Complexity

- Time complexity:
  O(n) where n is the length of the strings.

- Space complexity:
  O(1) as we are using fixed size array of size 26.

# Code

```
class Solution {
    int[] root = new int[26];

    // recursively get the root element
    int get(int x) {
        return x == root[x] ? x : (root[x] = get(root[x]));
    }

    // unite two elements
    void unite(int x, int y) {
        // find the root of x
        x = get(x);
        // find the root of y
        y = get(y);
        // if their roots are not same, we combine them
        if (x != y) {
            // smaller first
            if (x < y)
                root[y] = x;
            else
                root[x] = y;
        }
        return;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        String ans = "";
        // init root. initialy each element is in its own group.
        for (int i = 0; i < 26; i++)
            root[i] = i;
        // unite each character
        for (int i = 0; i < s1.length(); i++)
            unite(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        // build the final answer from the root element (smallest)
        for (int i = 0; i < baseStr.length(); i++) {
            ans += (char) (get(baseStr.charAt(i) - 'a') + 'a');
        }
        return ans;
    }
}
```
