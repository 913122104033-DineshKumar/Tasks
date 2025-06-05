package utils;

import java.util.ArrayList;
import java.util.List;

public class Products {
    int productId;
    String productName;
    double price;
    public Products (int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public static void printHeading () {
        System.out.println(("- ").repeat(20));
        System.out.print("| ");
        System.out.printf("%6s", "Id");
        System.out.printf("%6s", " ");
        System.out.printf("%6s", "Name");
        System.out.printf("%6s", " ");
        System.out.printf("%6s", "Price ");
        System.out.printf("%6s", " ");
        System.out.println("|");
        System.out.println(("- ").repeat(20));
    }

    public static List<Products> addProducts () {
        List<Products> products = new ArrayList<>();
        products.add(new Products(1, "Milk", 20));
        products.add(new Products(2, "Bread", 100));
        products.add(new Products(3, "Drinks", 50));
        products.add(new Products(4, "Butter", 100));
        products.add(new Products(5, "Cake", 200));
        return products;
    }

    public static void showProducts (List<Products> products) {
        printHeading();
        for (Products product : products) {
            System.out.print("| ");
            System.out.printf("%6s", product.getProductId());
            System.out.printf("%6s", " ");
            System.out.printf("%6s", product.getProductName());
            System.out.printf("%6s", " ");
            System.out.printf("%6s", product.getPrice());
            System.out.printf("%6s", " ");
            System.out.println("|");
        }
        System.out.println(("- ").repeat(20));
    }

    public String getProductName() {
        return productName;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }
}
