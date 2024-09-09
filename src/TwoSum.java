import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] nums = new int[n];

        // Get input for the array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Get input for the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Find and print the indices of the two numbers
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No pair exists.");
        }

        scanner.close();
    }

    // Function to find the two indices that sum to the target
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If it exists, return the indices of the complement and the current number
                return new int[] {map.get(complement), i};
            }

            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }

        // Return an empty array if no pair exists
        return new int[] {};
    }
}