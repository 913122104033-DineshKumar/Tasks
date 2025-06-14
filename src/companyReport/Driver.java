package companyReport;

public class Driver {
    private final int driverNo;
    private final String name;
    private boolean isAvailable;
    public Driver (int driverNo, String name) {
        this.driverNo = driverNo;
        this.name = name;
        this.isAvailable = true;
    }

    public int getDriverNo () {
        return driverNo;
    }

    public void setIsAvailable (boolean onRide) {
        this.isAvailable = onRide;
    }

    public boolean getIsAvailable () {
        return this.isAvailable;
    }

    public String toString () {
        return this.driverNo + " " + this.name + " ";
    }

}
