package Cache;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        System.out.println("Enter Cache Size: ");
        int size = scanner.nextInt();
        LRU lru = new LRU(size);
        String id;
        String value;
        while (isTrue) {
            System.out.println("Enter Option 1 for adding...");
            System.out.println("Enter Option 2 for getting...");
            System.out.println("Enter Option 3 for exiting...");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter id: ");
                    id = scanner.next();
                    System.out.println("Enter Value: ");
                    value = scanner.next();
                    lru.put(id, value);
                    break;
                case 2:
                    System.out.println("Enter id: ");
                    id = scanner.next();
                    System.out.println(lru.get(id));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    isTrue = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

}
