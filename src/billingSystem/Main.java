package billingSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Products> products = Products.addProducts();
        boolean isTrue = true;
        Map<Products, Integer> selectedProducts = new HashMap<>();
       while (isTrue) {
            System.out.println("Enter Option 1 for purchasing Products...");
            System.out.println("Enter Option 2 for Calculate Total Price and Generate Invoice...");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    boolean purchasing = true;
                    while (purchasing) {
                        System.out.println("List of Products Available");
                        Products.showProducts(products);
                        System.out.println("To exit from the purchasing Enter Option 6...");
                        System.out.println("To choose a product, Enter the product Id: ");
                        int productId = scanner.nextInt();
                        int quantity;
                        switch (productId) {
                            case 1:
                                System.out.println("Enter the Quantity: ");
                                quantity = scanner.nextInt();
                                selectedProducts.put(products.get(0), selectedProducts.getOrDefault(products.get(0), 0) + quantity);
                                break;
                            case 2:
                                System.out.println("Enter the Quantity: ");
                                quantity = scanner.nextInt();
                                selectedProducts.put(products.get(1), selectedProducts.getOrDefault(products.get(1), 0) + quantity);
                                break;
                            case 3:
                                System.out.println("Enter the Quantity: ");
                                quantity = scanner.nextInt();
                                selectedProducts.put(products.get(2), selectedProducts.getOrDefault(products.get(2), 0) + quantity);
                                break;
                            case 4:
                                System.out.println("Enter the Quantity: ");
                                quantity = scanner.nextInt();
                                selectedProducts.put(products.get(3), selectedProducts.getOrDefault(products.get(3), 0) + quantity);
                                break;
                            case 5:
                                System.out.println("Enter the Quantity: ");
                                quantity = scanner.nextInt();
                                selectedProducts.put(products.get(4), selectedProducts.getOrDefault(products.get(4), 0) + quantity);
                                break;
                            case 6:
                                System.out.println("Exiting from the purchasing...");
                                purchasing = false;
                                break;
                            default:
                                System.out.println("Invalid Product Id");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Calculating the Total...");
                    CalculateTotal.calculateAndGenerateBill(selectedProducts);
                    isTrue = false;
                    break;
                default:
                    System.out.println("Invalid input! Enter the valid Options(1 - 3)");
                    break;
            }
        }
    }
}