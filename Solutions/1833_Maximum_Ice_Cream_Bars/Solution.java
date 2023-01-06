import java.util.Arrays;

public class Solution {
    public static int maxIceCream(int[] costs, int coins) {
        // Sort the costs in ascending order
        Arrays.sort(costs);

        // Initialize the number of ice creams that can be bought to 0
        int result = 0;

        // Iterate through all costs
        for (int cost : costs) {
            // If the cost of the current ice cream is less than or equal to the number of
            // coins left,
            // then buy the ice cream
            if (cost <= coins) {
                result++;
                // Update the number of coins left
                coins -= cost;
            }
            // Otherwise, stop buying ice creams
            else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int costs[] = { 1, 6, 3, 1, 2, 5 };
        int coins = 20;
        System.out.println(maxIceCream(costs, coins));
    }
}
