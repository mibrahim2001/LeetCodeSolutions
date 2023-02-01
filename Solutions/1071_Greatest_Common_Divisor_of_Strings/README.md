# Intuition

The task is to find the greatest common divisor (gcd) of two strings. If the gcd exists, it must be a substring that can be repeatedly concatenated to form both strings.

# Approach

1. Check for the existence of the gcd:

- Concatenate the two strings in one direction, for example str1 + str2.
- Concatenate the two strings in the opposite direction, for example str2 + str1.
- If the two concatenated strings are equal, then a gcd exists. If they are not equal, then a gcd does not exist and the function returns an empty string.

2. Determine the base string:

- If the length of str1 is smaller than the length of str2, then str1 is the base string.
- If the length of str2 is smaller than or equal to the length of str1, then str2 is the base string.

3. Calculate the length of the gcd:

- The length of the gcd is equal to the greatest common divisor (gcd) of the lengths of the two strings. The gcd can be calculated using the Euclidean algorithm.

4. Return the gcd:

- Return the substring of the base string that has the calculated length as the gcd.

# Complexity

- Time complexity:
  O(log min(len(str1), len(str2))) - This is because the gcd function, which uses the Euclidean algorithm, has a time complexity of O(log min(a, b)).

- Space complexity:
  The function only uses a constant amount of additional space to store variables and does not grow with the size of the input strings.

# Code

```
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        String baseString;
        if (str1.length() < str2.length()) {
            baseString = str1;
        } else {
            baseString = str2;
        }

        int lenOfBaseString = gcd(str1.length(), str2.length());

        return baseString.substring(0, lenOfBaseString);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);

    }

}

```
