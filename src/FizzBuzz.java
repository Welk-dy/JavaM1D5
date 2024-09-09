import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of times to loop from user input
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        // Call the fizzBuzz function
        fizzBuzz(n);

        scanner.close();
    }

    // Function to perform FizzBuzz
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.print("Fizz");
            } else if (i % 5 == 0) {
                System.out.print("Buzz");
            } else {
                System.out.print(i);
            }

            // Add a comma separator, but not after the last element
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println(); // For a new line at the end
    }
}