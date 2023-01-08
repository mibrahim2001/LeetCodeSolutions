public class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
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

    public static void main(String[] args) {
        int gas[] = { 1, 2, 3, 4, 5 };
        int cost[] = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
