package personMatchingSystem;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    String gender;
    Person father;
    Person mother;
    List<Person> maternalCousins;
    List<Person> sons;
    List<Person> daughters;

    public Person (String name, String gender, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.maternalCousins = new ArrayList<>();
        this.sons = new ArrayList<>();
        this.daughters = new ArrayList<>();
    }
    
    public static List<Person> findMaternalCousins (Person person) {
        List<Person> maternalCousins = new ArrayList<>();
        String personGender = person.getGender();
        Person fatherGrandFather = person.getFather().getFather();
        Person motherGrandFather = person.getMother().getFather();
        if (fatherGrandFather != null) {
            List<Person> aunties = fatherGrandFather.getDaughters();
            if (personGender.equals("Male")) {
                for (Person aunt : aunties) {
                    maternalCousins.addAll(aunt.getDaughters());
                }
            } else {
                for (Person aunt : aunties) {
                    maternalCousins.addAll(aunt.getSons());
                }
            }
        }
        if (motherGrandFather != null) {
            List<Person> uncles = motherGrandFather.getSons();
            if (personGender.equals("Male")) {
                for (Person uncle : uncles) {
                    maternalCousins.addAll(uncle.getDaughters());
                }
            } else {
                for (Person uncle : uncles) {
                    maternalCousins.addAll(uncle.getSons());
                }
            }
        }
        return maternalCousins;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getMaternalCousins() {
        return maternalCousins;
    }

    public List<Person> getSons() {
        return sons;
    }

    public List<Person> getDaughters() {
        return daughters;
    }
}
