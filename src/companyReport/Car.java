package companyReport;

public class Car {
    private final int id;
    private final String name;
    private final int rate;
    private final int grade;
    private boolean isAvailable;
    public Car (int id, String name, int rate, int grade) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.grade = grade;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return this.rate;
    }

    public int getGrade() {
        return this.grade;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString () {
        return this.id + " " + this.name;
    }

}
