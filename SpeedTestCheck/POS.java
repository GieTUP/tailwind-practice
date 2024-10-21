package SpeedTestCheck;

import java.util.ArrayList;
import java.util.Scanner;

public class POS {

    public static ArrayList<String[]> products = new ArrayList<>();
    public static ArrayList<String[]> cart = new ArrayList<>();

    static {
        products.add(new String[] { "100", "Pancit", "13.5", "50" });
        products.add(new String[] { "101", "Hopia", "10.5", "25" });
        products.add(new String[] { "110", "Kape", "12.5", "20" });
        products.add(new String[] { "111", "Tubig", "15.5", "30" });
        products.add(new String[] { "001", "Itlog", "9.5", "45" });
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        double totalAmount = 0;
        int continueShopping = 1;

        while (continueShopping == 1) {
            totalAmount += addItemToCart(input);
            continueShopping = askToContinueShopping(input);
        }

        if (continueShopping != 1) {
            int manageCart = manageCartOptions(input);
            while (manageCart == 1) {
                deleteItemFromCart(input);
                manageCart = manageCartOptions(input);
            }
            printCart(totalAmount);
            processPayment(input, totalAmount);
        }
    }

    private static double addItemToCart(Scanner input) {
        System.out.print("Enter product code: ");
        String code = input.next();

        System.out.print("Enter qty: ");
        double qty = input.nextDouble();

        for (String[] product : products) {
            if (product[0].equals(code)) {
                double price = Double.parseDouble(product[2]);
                double subtotal = qty * price;

                cart.add(new String[] { product[0], product[1], product[2], String.valueOf(subtotal) });
                return subtotal;
            }
        }
        System.out.println("Product not found.");
        return 0; // Return 0 if product is not found
    }

    private static int askToContinueShopping(Scanner input) {
        System.out.println("Do you want to buy another item? <y=1>");
        return input.nextInt();
    }

    private static int manageCartOptions(Scanner input) {
        System.out.println("Would you like to manage your cart? <y=1>");
        return input.nextInt();
    }

    private static void deleteItemFromCart(Scanner input) {
        printCart(0); // Print the cart to show items before deletion
        System.out.print("Enter the code of the item you want to delete: ");
        String codeToDelete = input.next();

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i)[0].equals(codeToDelete)) {
                cart.remove(i);
                System.out.println("Item deleted from cart.");
                return;
            }
        }
        System.out.println("Item not found in cart.");
    }

    private static void printCart(double totalAmount) {
        System.out.println("--- MY CART ---");
        System.out.println("CODE:\t NAME:\t Price:\t TOTAL PRICE:\t");
        for (String[] item : cart) {
            System.out.println(item[0] + "\t" + item[1] + "\t" + item[2] + "\t" + item[3] + "\t");
        }
        if (totalAmount > 0) {
            System.out.println("YOUR TOTAL PRICE IS: \t " + totalAmount);
        }
    }

    private static void processPayment(Scanner input, double totalAmount) {
        System.out.print("Enter payment amount: ");
        double pay = input.nextDouble();
        System.out.println("Your change is: " + (pay - totalAmount));
    }
}