# Intuition

I am trying to calculate the minimum number of rounds required to complete a given set of tasks, where each round allows for a maximum of 3 tasks to be completed.

# Approach

First, I create a hash map that maps each unique task to the number of times it appears in the tasks array. I then iterate through the keys of the map and check the corresponding value for each key (i.e. the number of times the task appears in the tasks array). If the value is greater than or equal to 3, I calculate the minimum number of rounds required to complete all instances of the task by either dividing the value by 3 (if it is divisible by 3) or by dividing it by 3 and adding 1 (if it is not divisible by 3). If the value is 2, I add 1 to the minimum number of rounds. If the value is 1, I return -1, since it is not possible to complete the tasks successfully if only 1 task of that difficulty is available.

# Complexity

- Time complexity:
  O(n), where n is the length of the tasks array. This is because I iterate through the tasks array once and through the keys of the map once.

- Space complexity:
  O(n), where n is the length of the tasks array. This is because the hash map uses space proportional to the number of elements in the tasks array.

# Code

```
class Solution {
    public int minimumRounds(int[] tasks) {
         int minRounds = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value >= 3) {
                if (value % 3 == 0) {
                    minRounds += value / 3;
                } else {
                    minRounds += Math.floor(value / 3) + 1;
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
}
```
