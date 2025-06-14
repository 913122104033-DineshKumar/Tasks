package companyReport;

public class Employee {
    private final int empNo;
    private final String name;
    private final int grade;
    private final int distance;

    public Employee (int empNo, String name, int grade, int distance) {
        this.empNo = empNo;
        this.name = name;
        this.grade = grade;
        this.distance = distance;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getName () {
        return this.name;
    }

    public int getGrade() {
        return grade;
    }

    public int getDistance() {
        return distance;
    }

    public String toString () {
        return this.empNo + " " + this.name + " ";
    }

}
