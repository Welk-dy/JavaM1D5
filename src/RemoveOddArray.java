import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveOddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] inputArray = new int[n];

        // Get input from the user for each element
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }

        // Remove odd numbers from the array
        int[] evenNumbersArray = removeOddNumbers(inputArray);

        // Display the result
        System.out.println("Array with even numbers only: " + Arrays.toString(evenNumbersArray));

        scanner.close();
    }

    // Function to remove odd numbers from an array
    private static int[] removeOddNumbers(int[] array) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        // Iterate through the array and add only even numbers to the list
        for (int num : array) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        // Convert ArrayList to an array
        int[] result = new int[evenNumbers.size()];
        for (int i = 0; i < evenNumbers.size(); i++) {
            result[i] = evenNumbers.get(i);
        }

        return result;
    }
}