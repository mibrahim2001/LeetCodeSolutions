import java.util.Arrays;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        

        // Sort the list of strings to make the search for the common prefix more
        // efficient
        Arrays.sort(strs);
        // Get the first and last string in the sorted list
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];

        // Initialize a variable to store the common prefix
        String commonPrefix = "";
        // Iterate through the characters in the first and last string
        for (int i = 0; i < Math.min(firstStr.length(), lastStr.length()); i++) {
            // If the characters are the same, add it to the common prefix
            if (firstStr.charAt(i) == lastStr.charAt(i)) {
                commonPrefix += firstStr.charAt(i);
            }
            // If the characters are different, return the common prefix
            else {
                return commonPrefix;
            }
        }
        // If the common prefix is an empty string, return an empty string
        if (commonPrefix.isEmpty()) {
            return "";
        }
        // Return the common prefix
        return commonPrefix;
    }
}