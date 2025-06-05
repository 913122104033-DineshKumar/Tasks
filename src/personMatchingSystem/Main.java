package personMatchingSystem;

import java.util.*;

public class Main {

    private static Map<String, Person> family;

    public static void buildRelation (String name, String gender, String fatherName, String motherName) {
        Person father, mother;
        if (!family.containsKey(fatherName)) {
            father = new Person(fatherName, "Male", null, null);
            family.put(fatherName, father);
        } else {
            father = family.get(fatherName);
        }
        if (!family.containsKey(motherName)) {
            mother = new Person(motherName, "Female", null, null);
            family.put(motherName, mother);
        } else {
            mother = family.get(motherName);
        }
        Person person;
        if (family.containsKey(name)) {
            person = family.get(name);
            person.father = father;
            person.mother = mother;
        } else {
            person = new Person(name, gender, father, mother);
            family.put(name, person);
        }
        if (gender.equals("Male")) {
            father.sons.add(person);
            mother.sons.add(person);
        } else {
            father.daughters.add(person);
            mother.daughters.add(person);
        }
    }

    private static void printMaternalCousins (Person person) {
        for (Person maternalCousin : person.getMaternalCousins()) {
            System.out.print(maternalCousin.getName() + ", ");
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        family = new HashMap<>();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter Option 1 for adding...");
            System.out.println("Enter Option 2 for searching...");
            System.out.println("Enter Option 3 for Exiting...");
            int option = scanner.nextInt();
            String name;
            switch (option) {
                case 1:
                    System.out.println("Enter the Your Name: ");
                    name = scanner.next();
                    System.out.println("Enter the Gender: ");
                    String gender = scanner.next();
                    System.out.println("Enter the Father Name: ");
                    String fatherName = scanner.next();
                    System.out.println("Enter the Mother Name: ");
                    String motherName = scanner.next();
                    buildRelation(name, gender, fatherName, motherName);
                    break;
                case 2:
                    System.out.println("Enter the Your Name: ");
                    name = scanner.next();
                    family.get(name).maternalCousins = Person.findMaternalCousins(family.get(name));
                    printMaternalCousins(family.get(name));
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Enter a Valid input from 1 to 3");
                    break;
            }
        }
    }
}
