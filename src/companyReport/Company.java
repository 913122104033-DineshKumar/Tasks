package companyReport;

import java.time.LocalDate;
import java.util.*;

public class Company {
    private List<Employee> emps;
    private List<Trip> trips;
    private CarCompany carCompany;

    public Company () { }

    public void addEmployee (Employee emp) {
        this.emps.add(emp);
        this.trips = new ArrayList<>();
        this.carCompany = new CarCompany();
    }

    private void addTrip (Trip trip) {
        this.trips.add(trip);
        carCompany.addTrip(trip);
    }

    public String bookTrip (Employee employee) {
        Car car = carCompany.getAvailableCar(employee.getGrade());
        if (car == null) {
            return "Currently no car is available";
        }
        Driver driver = carCompany.getAvailableDriver();
        if (driver == null) {
            return "No Driver is currently available";
        }
        putInTrip(employee, driver, car);
        return "Car booked to ride, Thanks for the patience";
    }

    private void putInTrip (Employee employee, Driver driver, Car car) {
        int month = LocalDate.now().getMonthValue();
        Trip trip = new Trip(employee, driver, month, car, employee.getDistance(), employee.getDistance() * car.getRate());
        addTrip(trip);
    }

    public int generateMonthReport (int month) {
        Map<Employee, Integer> expenses = new HashMap<>();
        for (Trip t : trips) {
            Employee employee = t.getEmp();
            int monthGap = month - t.getMonth();
            if (monthGap == 1) {
                expenses.put(employee, expenses.getOrDefault(employee, 0) + t.getCost());
            }
        }
        System.out.println("Current Month: " + month);
        System.out.printf("%10s", "Employee No");
        System.out.printf("%10s", "Employee Name");
        System.out.printf("%10s", "Total Cost");
        int totalSpending = 0;
        for (Employee emp : expenses.keySet()) {
            int totalCost = expenses.get(emp);
            totalSpending  += totalCost;
            System.out.printf("%10s", emp.toString());
            System.out.printf("%10s", totalCost + "");
        }
        return totalSpending;
    }

}
