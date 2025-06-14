package companyReport;

public class Trip {
    private final Employee emp;
    private final Driver driver;
    private final int month;
    private final Car car;
    private final int km;
    private final int cost;

    public Trip(Employee emp, Driver driver, int month, Car car, int km, int cost) {
        this.emp = emp;
        this.driver = driver;
        this.month = month;
        this.car = car;
        this.km = km;
        this.cost = cost;
    }

    public Employee getEmp() {
        return emp;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getMonth() {
        return month;
    }

    public Car getCar() {
        return car;
    }

    public int getKm() {
        return km;
    }

    public int getCost() {
        return cost;
    }
}
