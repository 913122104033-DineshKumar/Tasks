package companyReport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarCompany {
    List<Car> cars;
    List<Driver> drivers;
    List<Trip> trips;

    public void addCar (Car car) {
        this.cars.add(car);
    }

    public void addDriver (Driver driver) {
        this.drivers.add(driver);
    }

    public void addTrip (Trip trip) {
        this.trips.add(trip);
    }

    public Car getAvailableCar (int empGrade) {
        for (Car c : cars) {
            if (c.isAvailable()  && c.getGrade() == empGrade) {
                return c;
            }
        }
        return null;
    }

    public Driver getAvailableDriver () {
        for (Driver d : drivers) {
            if (d.getIsAvailable()) {
                return d;
            }
        }
        return null;
    }

    public int generateProfitReport (int month) {
        Map<Car, Integer> profit = new HashMap<>();
        for (Trip t : trips) {
            Car car = t.getCar();
            int monthGap = month - t.getMonth();
            if (monthGap == 1) {
                profit.put(car, profit.getOrDefault(car, 0) + t.getCost());
            }
        }
        System.out.println("Current Month: " + month);
        System.out.printf("%10s", "Car No");
        System.out.printf("%10s", "Car Name");
        System.out.printf("%10s", "Total Profit");
        int totalProfit = 0;
        for (Car car : profit.keySet()) {
            int totalCost = profit.get(car);
            totalProfit  += totalCost;
            System.out.printf("%10s", car.toString());
            System.out.printf("%10s", totalCost + "");
        }
        return totalProfit;
    }

    public int generateExpenseReport (int month) {
        Map<Driver, Integer> expenses = new HashMap<>();
        for (Trip t : trips) {
            Driver driver = t.getDriver();
            int monthGap = month - t.getMonth();
            if (monthGap == 1) {
                expenses.put(driver, expenses.getOrDefault(driver, 0) + t.getCost());
            }
        }
        System.out.println("Current Month: " + month);
        System.out.printf("%10s", "Driver No");
        System.out.printf("%10s", "Driver Name");
        System.out.printf("%10s", "Total Expenses");
        int totalExpenses = 0;
        for (Driver driver : expenses.keySet()) {
            int totalCost = expenses.get(driver);
            totalExpenses  += totalCost;
            System.out.printf("%10s", driver.toString());
            System.out.printf("%10s", totalExpenses + "");
        }
        return totalExpenses;
    }

}
