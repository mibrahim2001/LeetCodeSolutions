public class DeleteColumnsToMakeSorted {
    public static int minDeletionSize(String[] strs) {
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

    public static void main(String[] args) {
        String strs[] = {"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs));
    }
}
