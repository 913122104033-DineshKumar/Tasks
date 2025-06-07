package personMatchingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {
    String name;
    String gender;
    Person father;
    Person mother;
    List<Person> sons;
    List<Person> daughters;
    List<Person> sisters;
    List<Person> brothers;

    public Person (String name, String gender, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.sons = new ArrayList<>();
        this.daughters = new ArrayList<>();
        this.sisters = new ArrayList<>();
        this.brothers = new ArrayList<>();
    }
    
    public static List<Person> findMaternalCousins (Person person) {
        List<Person> maternalCousins = new ArrayList<>();
        String personGender = person.getGender();
        List<Person> aunties = person.getFather().getSisters();
        List<Person> uncles = person.getMother().getBrothers();
        if (personGender.equals("Male")) {
            for (Person aunt : aunties) {
                maternalCousins.addAll(aunt.getDaughters());
            }
            for (Person uncle : uncles) {
                maternalCousins.addAll(uncle.getDaughters());
            }
        } else {
            for (Person aunt : aunties) {
                maternalCousins.addAll(aunt.getSons());
            }
            for (Person uncle : uncles) {
                maternalCousins.addAll(uncle.getSons());
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

    public List<Person> getSons() {
        return sons;
    }

    public List<Person> getDaughters() {
        return daughters;
    }

    public List<Person> getSisters() {
        return sisters;
    }

    public List<Person> getBrothers() {
        return brothers;
    }
}
