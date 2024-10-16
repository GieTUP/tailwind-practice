import java.util.ArrayList;
import java.util.Scanner;

public class POS {

    public static ArrayList<String[]> products = new ArrayList<>();
    public static ArrayList<String[]> cart = new ArrayList<>();
    static {
        products.add(new String[] { "100", "Pancit", "13.5", "50" });
        products.add(new String[] { "101", "Hopia", "10.5", "25" });
        products.add(new String[] { "110", "kape", "12.5", "20" });
        products.add(new String[] { "111", "Tubig", "15.5", "30" });
        products.add(new String[] { "001", "Itlog", "9.5", "45" });
    }
    //MAIN
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int yn = 1;
        double totalamount = 0;
        double pay;
        do {
            String code;
            double qty;
            double price;
            double subtotal;
            
                 
            input.nextLine();

            System.out.print("Enter product code: ");
            code = input.nextLine();

            System.out.print("Enter qty: ");
            qty = input.nextDouble();

            for (String[] product : products) {
                if (product[0].equals(code)) {
                    System.out.println("Code: " + product[0]);
                    System.out.println("Code: " + product[1]);
                    System.out.println("Code: " + product[2]);
                    System.out.println("Code: " + product[3]);

                    price = Double.parseDouble(product[2]);
                    subtotal = qty * price;
                 totalamount = totalamount + subtotal;

                    cart.add(new String[] { product[0], product[1], product[2], String.valueOf(subtotal) });

                }
            }

            System.out.println("Do you want to buy another item? <y=1>");
            yn = input.nextInt();

            if (yn != 1) {
                System.out.println("Exiting...");
            }
        } while (yn == 1);
        
        if (yn != 1) {
            System.out.println("--- MY CART ---");
            System.out.println("CODE:\t NAME: \t Price:\t TOTAL PRICE:\t");
            for (String[] item : cart) {
                System.err.println(item[0] + "\t" + item[1] + "\t" + item[2] + "\t" + item[3] + "\t");
            }

            System.out.println("YOUR TOTAL PRICE IS: \t " + totalamount);

            System.out.println("Enter payment amount: ");
            pay = input.nextInt();
            
             System.out.println("Your change is: " + (pay - totalamount));
        }
    }
}