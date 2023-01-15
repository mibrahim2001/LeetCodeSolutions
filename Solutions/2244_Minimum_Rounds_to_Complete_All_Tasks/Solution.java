import java.util.HashMap;

class MinimumRoundstoCompleteAllTasks {

    public static int minimumRounds(int[] tasks) {
        int minRounds = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value >= 3) {
                if (value % 3 == 0) {
                    // we can just divide the value by 3 and add it to minRounds
                    // because the maximum number of rounds we can complete at one time is 3
                    minRounds += value / 3;
                } else {
                    // if value is not divisible by 3 then we need to add 1 to the result
                    // because the remainder would be 2 and we would need 1 more round to complete
                    minRounds += (value / 3) + 1;
                }
            } else if (value == 2) {
                minRounds += 1;
            } else {
                // it means that value left is only 1 and we cannot complete all tasks
                return -1;
            }
        }

        return minRounds;
    }

    public static void main(String[] args) {
        int rounds[] = { 2, 3, 3 };
        System.out.println(minimumRounds(rounds));
    }

}