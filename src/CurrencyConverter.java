import java.util.Scanner;

public class CurrencyConverter {
    // Exchange rates
    private static final double USD_TO_EUR = 0.92;
    private static final double EUR_TO_USD = 1 / USD_TO_EUR; // 1.087
    private static final double USD_TO_GBP = 0.79;
    private static final double GBP_TO_USD = 1 / USD_TO_GBP; // 1.266
    private static final double USD_TO_JPY = 147.65;
    private static final double JPY_TO_USD = 1 / USD_TO_JPY; // 0.0068

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (USD, EUR, GBP, or JPY): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (USD, EUR, GBP, or JPY): ");
        String targetCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

        if (convertedAmount != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, sourceCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency conversion request.");
        }

        scanner.close();
    }

    // Method to convert currency
    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        if (sourceCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return amount * USD_TO_EUR;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return amount * EUR_TO_USD;
        } else if (sourceCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return amount * USD_TO_GBP;
        } else if (sourceCurrency.equals("GBP") && targetCurrency.equals("USD")) {
            return amount * GBP_TO_USD;
        } else if (sourceCurrency.equals("USD") && targetCurrency.equals("JPY")) {
            return amount * USD_TO_JPY;
        } else if (sourceCurrency.equals("JPY") && targetCurrency.equals("USD")) {
            return amount * JPY_TO_USD;
        } else if (sourceCurrency.equals(targetCurrency)) {
            return amount; // No conversion needed
        } else {
            return -1; // Invalid conversion request
        }
    }
}