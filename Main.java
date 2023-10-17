import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> menu = new HashMap<>();
        menu.put("C1", 100.00);
        menu.put("C2", 150.00);
        menu.put("C3", 200.00);
        menu.put("R1", 35.00);
        menu.put("R2", 50.00);

        Map<String, Integer> orders = new HashMap<>();
        double total = 0.0;

        System.out.println("Welcome to the Order Application!");
        System.out.println("Menu:");
        for (String item : menu.keySet()) {
            System.out.println(item + " - Php " + menu.get(item));
        }
        System.out.println("Add 'Q' to quit the order process.");

        while (true) {
            System.out.print("Enter your selection (e.g., C1, R2, Q to quit): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Q")) {
                break;
            }

            if (!menu.containsKey(input)) {
                System.out.println("Invalid selection. Please try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero. Please try again.");
                continue;
            }

            if (orders.containsKey(input)) {
                orders.put(input, orders.get(input) + quantity);
            } else {
                orders.put(input, quantity);
            }

            total += menu.get(input) * quantity;
        }

        System.out.println("Your Orders:");

        for (String item : orders.keySet()) {
            int quantity = orders.get(item);
            double price = menu.get(item);
            System.out.println(item + " - Qty: " + quantity + " - Total: Php " + (price * quantity));
        }

        double usdTotal = total / 50.0; // Assuming 1 PHP = 50 USD
        System.out.println("Total Price (PHP): Php " + total);
        System.out.println("Total Price (USD): $ " + usdTotal);

        scanner.close();
    }
}
