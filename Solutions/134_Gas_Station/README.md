# Intuition

This code is checking if it is possible to complete a circuit given a list of gas stations and the cost to go from one station to the next.

# Approach

The code first calculates the total gas and total cost for the circuit. If the total cost is more than the total gas, it is not possible to complete the circuit. Otherwise, the code checks if it is possible to complete the circuit by starting at each gas station and ensuring that the remaining gas is non-negative at each station. If the remaining gas becomes negative, it means the starting station is not valid, so the starting station is updated to the next station and the remaining gas is reset to 0.

# Complexity

- Time complexity:
  The code loops through the gas and cost arrays once, so the time complexity is linear with respect to the number of gas stations (n).

- Space complexity:
  The code only uses a few variables to store intermediate values, so the space complexity is constant.

# Code

```
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int totalGas = 0;
        int totalCost = 0;
        int curGas = 0;
        int startIndex = 0;
        /*
         * What we do is calculate the total gas and total cost
         * if the total cost is more than the toal gas round trip is not possible
         */
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            curGas += gas[i] - cost[i];
            /*
             * Secondly we check if the curGas has become negative if yes that means
             * starting index is not correct
             * so we update the start index to the next index and reset the curGas to 0
             */
            if (curGas < 0) {
                startIndex = i + 1;
                curGas = 0;
            }
        }
        /*
         * If the total gas is not less than total cost we are good to go from the
         * starting index
         */
        return totalGas < totalCost ? -1 : startIndex;
    }
}
```
