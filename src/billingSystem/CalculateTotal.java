package billingSystem;
import java.util.Map;

public class CalculateTotal {

    private static void formattingResult (String column1Name, String column2Name, int space1, int space2) {
        System.out.print("| ");
        System.out.printf("%6s", "");
        System.out.printf("%5s", " ");
        System.out.printf("%6s", column1Name);
        System.out.printf("%" + space1 + "s", " ");
        System.out.printf("%6s", column2Name);
        System.out.printf("%" + space2 + "s", " ");
        System.out.println("|");
    }

    public static void calculateAndGenerateBill (Map<Products, Integer> products) {
        double totalPrice = 0.0;
        Products.printHeading();
        for (Products key : products.keySet()) {
            int quantity = products.get(key);
            double price = key.getPrice();
            totalPrice += price * quantity;
            System.out.print("| ");
            System.out.printf("%6s", key.getProductId());
            System.out.printf("%6s", " ");
            System.out.printf("%6s", key.getProductName());
            System.out.printf("%6s", " ");
            System.out.printf("%6s", price * quantity);
            System.out.printf("%6s", " ");
            System.out.println("|");
        }
        int discount = 0;
        int tax = 12;
        if (totalPrice >= 500) {
            discount += 5;
        }
        formattingResult("Discount", "-" + discount + "%", 3, 8);
        totalPrice -= totalPrice * (discount / 100.0);
        formattingResult("Tax", "+" + tax + "%", 6, 7);
        totalPrice += totalPrice * (tax / 100.0);
        formattingResult("Total", totalPrice + "", 7, 6);
        System.out.println(("- ").repeat(20));
    }
}
